require_relative 'parser'


parser = Parser.new

main_url = gets.chomp
parser.get_links(main_url)
file_name = gets.chomp
parser.writeData(file_name)
