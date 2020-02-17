###############
# Basic Maths #
###############

# 'Tests' Examples
 
test_1 = 17 > 16
 
test_2 = 21 < 30
 
test_3 = 9 >= 9
 
test_4 = -11 < 4
 
# More 'Tests' Examples
 
test_5 = 77 != 77
test_5 = false
 
test_6 = -4 <= -4
test_6 = true
 
test_7 = -44 < -33
test_7 = true
 
test_8 = 100 == 1000
test_8 = false
 
# 'True'/'False' Examples
 
is_true = 2 != 3
 
is_false = 2 == 3
 
## 'If'/'Elsif'/'Else' Examples

# '15'
 
if 15 > 15
    puts "15 is less than 15!"
elsif 15 < 15
    puts "15 is more than 15!"
else
    puts "15 does equal 15!"
end

# 'x' and 'y'

x = 15
y  = 10
if x > y
    print "Y is less than X."
elsif x < y
    print "X is less than X."
else
    print "X is equal to Y."
end