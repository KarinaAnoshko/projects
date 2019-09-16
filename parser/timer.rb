class Timer
  OFFER_TO_USE_TIMER = "DO YOU WANT TO USE A TIMER TO DELAY BETWEEN RECEIVING PAGES?"
  ABOUT_ADMINISTRATOR = "So as not to attract the attention of the administrator. \nWe cares about him :) "
  WARNING_ABOUT_TIMER = "WARNING: If you use a timer, this increases the execution time."
  INSTRUCTION = "Enter Y (yes) or N (no)? \nA delay automatically generated from 0 to your value."
  ENTER_MAX_DELAY = "Enter maximum time delay: "
  @max_delay = 0

  def message_about_timer
    puts OFFER_TO_USE_TIMER
    puts ABOUT_ADMINISTRATOR
    puts WARNING_ABOUT_TIMER
    puts INSTRUCTION
  end


  def request_to_use_timer
    message_about_timer
    begin
      answer = gets.chomp
      if "Y".eql?(answer.to_s.upcase) then
        get_range
      elsif "N".eql?(answer.to_s.upcase) then
        false
      else
        raise ArgumentError.new
        end
    rescue ArgumentError
      puts "Incorrect value. Try again"
      retry
    end
  end

  def get_range
    begin
      puts ENTER_MAX_DELAY
      @max_delay = gets.chomp
      check = Regexp.new(/[1-9]{1,2}/)===(@max_delay)
      if check == false
        raise ArgumentError.new
      end
    rescue ArgumentError
      puts "Incorrect value. Try again"
      retry
    rescue Exception
      puts "Sorry, try again"
      retry
    end
  end

  def delay
    _random = rand(@max_delay.to_i)
    puts "Paused for #{_random} seconds"
    if _random.nil? == true then
      _random = 0
    else
    Time.new(_random)
    sleep(_random)
    end
  end

end