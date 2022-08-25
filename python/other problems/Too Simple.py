one = (int)(True)

ten = one + one + one + one + one + one + one + one + one + one

H = ten * (ten - one - one - one) + one + one
e = ten * ten + one
l = ten * ten + ten - one - one
o = ten * ten + ten + one
comma = ten * (one + one + one + one) + one + one + one + one
space = ten * (one + one + one) + one + one
W = ten * ten - ten - one - one - one
r = ten * ten + ten + one + one + one + one
d = ten * ten
exclaim = ten + ten + ten + one + one + one

arr = [H, e, l, l, o, comma, space, W, o, r, l, d, exclaim]

print(chr(H) + chr(e) + chr(l) + chr(l) + chr(o) + chr(comma) + chr(space) + chr(W) + chr(o) + chr(r) + chr(l) + chr(d) + chr(exclaim))
