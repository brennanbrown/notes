# Introductory text
print 'Welcome to the Restaurant Bill Generator!'
 
# Asking for user input
print 'What is your bill amount? (In $)'
bill = raw_input
print 'What is your tax amount? (In %)'
tax = raw_input
print 'What is your tip amount? (In %)'
tip = raw_input

# Validating the input to make sure that it is both
  # 1. Above the length of zero (not empty).
  # 2. Only numeric characters only.
if len(bill) >= 0 and bill.isdigit():
  
  taxbill = bill * ((tax / 100) + 1)
  print "Your tax would amount to: $%s" % taxbill

  tipbill = bill * ((tip / 100) + 1)
  print "Your tip would amount to: $%s" % tipbill

  tiptax = bill * (((tip + tax) / 100) + 1)
  print "Your total would amount to: $%s" % tiptax 
  print tiptax
 
  # Error message that's printed if nothing is written.
elif len(bill) == 0:
  print "Please write something!"
 
  # Error message that's printed if non-numeric
  # characters are written.
else:
  print 'Please write only numeric characters (0-9)'