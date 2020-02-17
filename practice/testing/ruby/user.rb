#########################
# User Information Test #
#########################

# A snippet of code I learned from Codecademy that may or may not work the way it's supposed to.
 
print "What's your first name?"
  variable_first_name = gets.chomp
  variable_first_name2 = variable_first_name.capitalize
  variable_first_name.capitalize!
puts "Your name is #{first_name}!"
 
print "What's your last name?"
  variable_last_name = gets.chomp
  variable_last_name2 = variable_last_name.capitalize
  variable_last_name.capitalize!
puts "Your last name is #{last_name}!"
 
print "What city are you from?"
  variable_city = gets.chomp
  variable_city2 = variable_city.capitalize
  variable_city.capitalize!
puts "You live in #{city}!"
 
print "What state/province are you from? (Use abbreviation)"
  variable_state = gets.chomp
  variable_state2 = variable_state.upcase
  variable_state.upcase!
puts "You also live in #{state}!"