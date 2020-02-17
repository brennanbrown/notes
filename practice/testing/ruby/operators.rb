#####################
# Logical Operators #
#####################

=begin

Logical operators are used to compare to boolean values. Ruby has 6 operators to compare boolean values:

1. and 
2. or 
3. not 
4. && 
5. || 
6. not. 

The following perform the same function:

i. 'and' = '&&'
ii. 'or' = '||',
iii. 'not' = '!' 

However, the verbiage operators ('and', 'or' and 'not') have LOWER precedence than the symbolic operators ('&&', '||' and '!').

=end 

# 'Or' Examples
 
boolean_1 = 2**3 != 3**2 || true
boolean_1 = true
 
boolean_2 = false || -10 > -9
boolean_2 = false
 
boolean_3 = false || false
boolean_3 = false
 
# 'And' Examples
 
boolean_4 = 77 < 78 && 77 < 77
boolean_4 = false
 
boolean_5 = true && 100 >= 100
boolean_5 = true
 
boolean_6 = 2**3 == 8 && 3**2 == 9
boolean_6 = true
 
# 'Not' Examples
 
boolean_7 = !true
boolean_7 = false
 
boolean_8 = !true && !true
boolean_8 = false
 
boolean_9 = !(700 / 10 == 70)
boolean_9 = false
 
# 'Combination' Examples
 
boolean_10 = (3 < 4 || false) && (false || true)
boolean_10 = true
 
boolean_11 = !true && (!true || 100 != 5**2)
boolean_11 = false
 
boolean_12 = true || !(true || false)
boolean_12 = true

# 'Test' Examples

# test_1 should be true
test_1 = ( 10 == 5 ) || ( 10 != 5 && 10 > 5)

# test_2 = should be true
test_2 = ( 5 == 5 || !25 == 25 ) && ( !false ) 

# test_3 = should be false
test_3 = !true && false