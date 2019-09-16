require_relative 'timer'
require 'nokogiri'
require 'curb'
require 'curl'
require 'csv'

class Parser

  ENTER_LINK = "Enter link (url): "
  ENTER_FILE_NAME = "Enter file name: "
  CONDITION_FOR_GET_URLS = ".//a[@class='product_img_link product-list-category-img']/@href"
  CONDITION_FOR_GET_IMAGES = ".//div[@id = 'thumbs_list']/ul"
  CHECK_PAGINATION = ".//link[@rel='next']/@href"
  CONDITION_FOR_GET_WEIGHT_AND_PRICE = ".//div[@class='attribute_list']/ul/li/label"
  CONDITION_FOR_GET_NAME = ".//h1[@class='product_main_name']"
  PRODUCT_HEADERS = "Product name", "Product price", "Product image"


  def initialize
    @links = Array.new
    @data = []
    @easy = Curl::Easy.new
    @index = 0
    @timer = Timer.new
    @timer.message_about_timer
    @timer.request_to_use_timer
    puts ENTER_LINK
  end

  def get_links(url)
    begin
      @easy.url = url
      @easy.perform
    page = Nokogiri::HTML(@easy.body)
    page.xpath(CONDITION_FOR_GET_URLS).each do |urls|
      @links << urls
      puts "Product № " + "#{@links.size}  --->" + " #{urls} "
    end
    pagination = page.xpath(CHECK_PAGINATION)
    unless pagination.to_s.empty?
      @timer.delay
      get_links(pagination.to_s)
    end
    rescue Curl::Err::HostResolutionError
      puts  "Check connection and url ad try again"
    rescue Curl::Err::MalformedURLError
      puts "Check entered data"
    rescue Exception
      puts "Sorry, try later"
    end
  end

  def getData
    begin
    number_of_product = 0
@links.each do |product|
      @easy.url = product
        @timer.delay
      @easy.perform
      page = Nokogiri::HTML(@easy.body)
      puts "-----------------"
      number_of_product += 1
      puts "    Product number --->  #{number_of_product}"
      name = page.xpath(CONDITION_FOR_GET_NAME).text
      puts "Name ---> #{name}"
      index = 1
      _image = ""
      page.xpath(CONDITION_FOR_GET_WEIGHT_AND_PRICE).each do |node|
        weight = node.xpath("./span[1]").text
          puts "Weight ---> #{weight}"
          _image = page.xpath(".//div[@id = 'thumbs_list']/ul/li[#{index}]/a/@href")
          if _image.index.nil? == true
            _image = page.xpath(".//div[@id = 'thumbs_list']/ul/li[1]/a/@href")
          end
          puts "Image ---> #{_image}"
          index += 1
          price = node.xpath("./span[2]").text
          puts "Price ---> #{price} "
        @data.push({
                       product_name: "#{name} — #{weight}",
                       product_price: " #{price} ",
                       product_picture: " #{_image} "
                   })
      end
    end
    puts ENTER_FILE_NAME
    rescue Curl::Err::HostResolutionError
      puts "Check connection and try again."
    rescue Exception
      puts "Sorry, try later"
    end
  end

  def writeData(file_name)
    begin
    CSV.open(file_name, 'wb', write_headers: true,headers: true, headers: PRODUCT_HEADERS) do |file|
      puts "Write a products..."
      @data.each {|product| file << product.values }

    puts "Products recorded!"
    puts "<==== Process finished! ====>"
    end
    rescue MalformedCSVError
      puts "Incorrect data. Try again"
    rescue Exception
      puts "Sorry, try later"
    end
  end
end
