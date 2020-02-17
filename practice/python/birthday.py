						   		# Function Design Recipe #

	# Header
def get_birthday_weekday(current_weekday, current_day, birthday_day):
	
	""" 
		# Type Contract:
	(int, int, int) -> int


		# Description:
	Return the day of the week it will be on birthday_day,
	given that the day of the week is current_weekday and the
	day of the year is current_day.

	current_weekday is the current day of the week and is in 
	the range 1-7, indicating whether today is Sunday (1),
	Monday (2), ..., Saturday (7).

	current_day and birthday_day are both in the range 1-365.


		# Examples:
	>>> get_birthday_weekday(5, 3, 4)
	6
	>>> get_birthday_weekday(5, 3, 116)
	6
	>>> get_birthday_weekday(6, 116, 3)
	5
	"""

		# Body
	days_diff = days_difference(current_day, birthday_day)
	return get_weekday(current_weekday, days_diff)
