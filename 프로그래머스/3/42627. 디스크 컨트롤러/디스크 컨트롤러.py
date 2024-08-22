import heapq;
def solution(jobs):

    jobs.sort(key=lambda x: x[0])

    pq = []
    curr = 0
    total = 0
    idx = 0
    process = 0

    while process < len(jobs):

        while idx < len(jobs) and jobs[idx][0] <= curr:
            heapq.heappush(pq, (jobs[idx][1], jobs[idx]))
            idx += 1

        if not pq:
            curr = jobs[idx][0]
        else:

            job_duration, curr_job = heapq.heappop(pq)
            curr += job_duration
            total += curr - curr_job[0]
            process += 1


    return total // len(jobs)