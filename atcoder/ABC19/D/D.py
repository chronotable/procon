import sys

n = int(raw_input())
cur = 1
ans = 0
for s in range(0, 2):
    mx = 0
    cand = -1
    for i in range(1, n+1):
        if i == cur:
            continue
        print "? %d %d" % (cur, i)
        sys.stdout.flush()
        dis = int(raw_input())
        if mx < dis:
            mx = dis
            cand = i
    cur = cand
    ans = max(ans, mx)
print "! %d" % ans
sys.stdout.flush()
