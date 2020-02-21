#!/usr/bin/env python
# -*- coding: utf-8 -*-

# Create a class that allows a user to input multiple numbers
# and output/write to file the largest or smallest one,
# depending on what method they choose to utilize in the terminal.

class myClass():
	def functionChooser(self):
		c = myClass()
		choice = input("Hello! Press '1' for the largest-finder program, or '2' for the smallest-finger program. ")
		if choice == 1:
			c.largestThree()
		elif choice == 2:
			c.smallestTwo()
		else:
			print("Please try your choice again. ")
			c.functionChooser()
		
	# TODO: Function receives 3 parameters, returns largest.
	def largestThree(self):
		# TODO: Santize results to make sure people only enter numbers.
		print("Welcome to the large-number-finder program! ")
		
		x = input("Write your first number. ")
		y = input("Write your second number. ")
		z = input("Write your third number. ")
		
		if (x == y) and (y == z):
			print("All three numbers of {} are equal! ".format(x))
			f.write("All three numbers of {} are equal! ".format(x))
			return x
		elif (x > y) and (x > z):
			print("The number {} is the largest. ".format(x))
			f.write("The number {} is the largest, ".format(x))
			return x
		elif (y > x) and (y > z):
			print("The number {} is the largest. ".format(y))
			f.write("The number {} is the largest. ".format(y))
			return y
		else:
			print("The number {} is the largest. ".format(z))
			f.write("The number {} is the largest. ".format(z))
			return z
			
	# TODO: Function receives 2 parameters, returns smallest.
	def smallestTwo(self):
		c = myClass()
		print("Welcome to the smallest-number-finder program! ")
		
		a = input("Write your first number. ")
		b = input("Write your second number. ")
		
		if type(a) != int or type(b) != int:
			print("Please write only numbers. \n")
			c.smallestTwo()
		else:
			if (a > b):
				print("The number {} is the smallest. ".format(b))
				f.write("The number {} is the smallest. ".format(b))
				return b
			elif (a < b):
				print("The number {} is the smallest. ".format(a))
				f.write("The number {} is the smallest. ".format(a))
				return a
			else:
				print("Both numbers of {} are equal! ".format(a))
				f.write("Both numbers of {} are equal! ".format(a))
				return a



def main():
	c = myClass()
	c.functionChooser()

if __name__ == '__main__':
	# Open a file for writing and create it if it doesn't exist.
	f = open("TEST.txt", "w+")
	main()
	# Close the file when finished operations.
	f.close()

