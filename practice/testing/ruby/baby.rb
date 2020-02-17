print "Put a hilarious input here."
    user_input = gets.chomp
    
if user_input.include? "r"
    user_input.gsub!(/r/, "w")
else
    nil
end

if user_input.include? "R"
    user_input.gsub!(/R/, "W")
else
    nil
end

if user_input.include? "o"
    user_input.gsub!(/o/, "aw")
else
    nil
end

puts "#{user_input}"