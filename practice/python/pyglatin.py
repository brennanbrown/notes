# Introductory text
print 'Welcome to the Pig Latin Translator!'
 
# Asking for user input
original = raw_input('Enter a word:')
 
# Variable for the Pig Latin
pyg = 'ay'
 
# Validating the input to make sure that it is both
  # 1. Above the length of zero (not empty).
  # 2. Only alphabetic characters only.
if len(original) >= 0 and original.isalpha():
  
    # Takes the original input and converts it to lowercase.
  word = original.lower()
  
    # Takes the first letter of the lowercase word.
  first = word[0]
  
    # Combines:
      # 1. The lowercase word
      # 2. The first letter of the lowercase word
      # 3. The pyg variable 'ay'
  new_word = word + first + pyg
  
    # Recreates the variable without it's first letter
    # to finally make the word actual Pig Latin.
  new_word = new_word[1:]
  
    # Prints the newly generated word!
  print new_word
 
  # Error message that's printed if nothing is written.
elif len(original) == 0:
  print "Please write something!"
 
  # Error message that's printed if non-alphabetical
  # characters are written.
else:
  print 'Please write only alphabetical characters. (A-Z)'
