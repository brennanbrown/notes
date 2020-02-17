#########
# LOOPS #
#########
 
# While Loop
 
counter = 1
while counter < 11
  puts counter
  counter = counter + 1
end
 
# While Infinite Loop: Error
 
i = 0
while i
  puts i
  
end
 
# While Infinite Loop: Fix
 
i = 1
while i < 5
  puts i
  i = i + 1
  
end
 
# Until Loop
 
counter = 1
until counter > 10
  puts counter
  counter = counter + 1
  
end
 
# Assignment Operator
 
counter = 1
while counter < 11
  puts counter
  counter += 1
end
 
# For Loop that excludes 10
 
for num in 1...10
  puts num
end
 
# For Loop that includes 10
 
for num in 1..10
  puts num
end
 
# Iterator Loop
 
=begin
In Ruby, curly braces '{}' are generally 
interchangeable with the keywords do 
(to open the block) and end (to close it). 
=end
 
i = 20
loop do
  i -= 1
  print "#{i}"
  break if i <= 0
end
 
# Next Loop for odd numbers only
 
i = 20
loop do
  i -= 1
  next if i % 2 == 0
  print "#{i}"
  break if i <= 0
end
 
 
# Next Loop for even numbers only
 
i = 20
loop do
  i -= 1
  next if i % 2 == 1
  print "#{i}"
  break if i <= 0
end
 
 
#############
# ITERATORS #
#############
 
# Saving Multiple Values
 
begin
    my_array = [1, 2, 3, 4, 5]
end
 
# .each Iterator
 
array = [1,2,3,4,5]
 
array.each do |x|
  x += 10
  print "#{x}"
end
 
# Doubling Odd Numbers
 
odds = [1,3,5,7,9]
 
odds.each do |item|
    puts (item * 2)
end
 
# .times Iterator
 
myArray = [1, 3, 5]
yourArray = [-1, -3, -5]
 
5.times { print (myArray + yourArray) }

    Write Preview 

Parsed as Markdown Edit in fullscreen
