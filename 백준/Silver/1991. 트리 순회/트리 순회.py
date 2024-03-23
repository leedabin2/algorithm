import sys

N = int(sys.stdin.readline().rstrip())

def preorder(node):
    print(node, end='')
    if tree[node][0] != '.':
        preorder(tree[node][0])
    if tree[node][1] != '.':
        preorder(tree[node][1])


def inorder(node):
    if tree[node][0] != '.':
        inorder(tree[node][0])
    print(node, end='')
    if tree[node][1] != '.':
        inorder(tree[node][1])


def postorder(node):
    if tree[node][0] != '.':
        postorder(tree[node][0])
    if tree[node][1] != '.':
        postorder(tree[node][1])
    print(node,end='')

tree = {}
for _ in range(N):
    node,left,right = map(str,sys.stdin.readline().split())
    tree[node] = left,right

preorder('A')
print()
inorder('A')
print()
postorder('A')