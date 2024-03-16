import sys,math

A,B,V = map(int,sys.stdin.readline().split())

arrive = ((V-B-1) / (A-B)) + 1
res = math.trunc(arrive)
print(res)
