require_relative 'parser'


parser = Parser.new

main_url = gets.chomp
parser.get_links(main_url)
parser.getData
file_name = gets.chomp
parser.writeData(file_name)
