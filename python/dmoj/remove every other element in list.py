str = input()

def string_bits(str):
  result = ""
  # Many ways to do this. This uses the standard loop of i on every char,
  # and inside the loop skips the odd index values.
  for i in range(len(str)):
    if i % 2 == 0:     # i is actually the index of the value, not the actual value
      result = result + str[i]   # btw 0 % 2 is 0 so thats why
  return result

OR

str = input()
def string_bitz(str):
  str = list(str)
  return str[::2]

string_bitz(str)
