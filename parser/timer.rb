class Timer
  OFFER_TO_USE_TIMER = "DO YOU WANT TO USE A TIMER TO DELAY BETWEEN RECEIVING PAGES?"
  ABOUT_ADMINISTRATOR = "So as not to attract the attention of the administrator. \n We cares about him :) "
  WARNING_ABOUT_TIMER = "WARNING: If you use a timer, this increases the execution time."
  INSTRUCTION = "Enter Y (yes) or N (no)"
  ENTER_MIN_DELAY = "Enter minimum value: "
  ENTER_MAX_DELAY = "Enter maximum value: "
  @random = 0

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
      max_delay = gets.chomp
      check = Regexp.new(/[1-9]/)===(max_delay)
      if check == false
        raise ArgumentError.new
      end
      @random = rand(max_delay.to_i)
    rescue ArgumentError
      puts "Incorrect value. Try again"
      retry
    rescue Exception
      puts "Sorry, try again"
      retry
    end
    puts @random
    @random
  end

  def delay
    puts "Paused for #{@random} seconds"
    if @random.nil? == true then
      @random = 0
    else
    Time.new(@random)
    sleep(@random)
    end
  end

end