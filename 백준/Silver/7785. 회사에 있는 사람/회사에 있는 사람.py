import sys

def solution():
    n = int(sys.stdin.readline().strip()) 
    employees = set()  


    for _ in range(n):
        name, status = sys.stdin.readline().strip().split()
        if status == "enter":
            employees.add(name)
        else:
            employees.remove(name) 


    for name in sorted(employees, reverse=True):
        print(name)

if __name__ == "__main__":
    solution()
