
# Without .split(), these variables would have to be
# entered like this:   abc.   .split() splits the input
# by space (default) for you to input
# the information in

A, B, C = input("Enter 3 values without any form to divide them  ")
a, b, c = input("Enter 3 values divided by a space  ").split()
black = input().split()  # this takes in the input, then converts it into a list separated by space
                         # you can then do black.find("l") or something which will return 2 (index)
print("Outputs are the same, just inputting are different")
print(A, B, C)
print(a, b, c)
print(black)
