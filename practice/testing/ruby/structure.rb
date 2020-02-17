# Ruby Data Structures

languages = ["HTML", "CSS", "JavaScript", "Python", "Ruby"]

languages.each { |script| puts script }

# Multidimensional Arrays

s = [["ham", "swiss"], ["turkey", "cheddar"], ["roast beef", "gruyere"]]

s.each do | sub_array |
    sub_array.each do | x |
        puts x
    end
end

# Iterating Over Hashes

secret_identities = {
  "The Batman" => "Bruce Wayne",
  "Superman" => "Clark Kent",
  "Wonder Woman" => "Diana Prince",
  "Freakazoid" => "Dexter Douglas"
}
  
secret_identities.each do |superhero, citizen|
    puts "#{superhero}: #{citizen}"
end

# ?? Array

my_array = [[1,2,3],[11,12,13],[14,15,16]]

=begin
{
  "B" => "C",
  "D" => "E",
  "F" => "G",
  "H" => "I"
}
=end
# your_array = 

my_array.each do | x |
    x.each do | y |
        puts y
    end
end


# ?? Hash

my_hash = { 
  "apple" => 0.52,
  "banana" => 0.23,
  "kiwi" => 1.42
}

sounds = Hash.new
sounds["dog"] = "woof"
sounds["cat"] = "meow"

# Iterating Over a Hash

lunch_order = {
  "Ryan" => "wonton soup",
  "Eric" => "hamburger",
  "Jimmy" => "sandwich",
  "Sasha" => "salad",
  "Cole" => "taco"
}

lunch_order.each do |x, y|
    puts "#{y}"
end