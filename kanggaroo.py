from sys import stdin

A,B,C = map(int, stdin.readline().split())

print(max(B-A-1,C-B-1))