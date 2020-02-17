# I don't think this works.
 
=begin
TODO:
-Redactor redacts a word regardless of whether it's upper case or lower case.
-Program take multiple, separate words to REDACT.
-Make a new redacted string and save it as a variable, rather than just printing it to the console.
=end
 
begin
puts "Original Text: "
text gets.chomp
 
puts "Words to Redact: "
redact gets.chomp
 
words = text.split(" ")
 
words.each do |lang|
    if lang != redact
        print lang + " "
    else
        print "REDACTED " 
    end
end

    Write Preview 

Parsed as Markdown Edit in fullscreen
