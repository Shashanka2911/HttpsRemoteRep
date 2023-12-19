#include <stdio.h>

#define MAX_PROCESS 10

struct Process {
    int id;
    int burst_time;
    int remaining_time;
    int turnaround_time;
    int waiting_time;
};

void roundRobin(struct Process processes[], int n, int time_quantum) {
    int remaining_processes = n;
    int current_time = 0;

    while (remaining_processes > 0) {
        for (int i = 0; i < n; i++) {
            if (processes[i].remaining_time > 0) {
                int execution_time = (processes[i].remaining_time < time_quantum) ? processes[i].remaining_time : time_quantum;
                current_time += execution_time;
                processes[i].remaining_time -= execution_time;

                if (processes[i].remaining_time == 0) {
                    remaining_processes--;

                    // Calculate turnaround time and waiting time
                    processes[i].turnaround_time = current_time;
                    processes[i].waiting_time = processes[i].turnaround_time - processes[i].burst_time;
                }
            }
        }
    }
}

int main() {
    int n, time_quantum;
    struct Process processes[MAX_PROCESS];

    printf("Enter the number of processes: ");
    scanf("%d", &n);

    printf("Enter the time quantum: ");
    scanf("%d", &time_quantum);

    for (int i = 0; i < n; i++) {
        processes[i].id = i + 1;
        printf("Enter burst time for Process %d: ", processes[i].id);
        scanf("%d", &processes[i].burst_time);
        processes[i].remaining_time = processes[i].burst_time;
    }

    roundRobin(processes, n, time_quantum);

    // Display the table
    printf("Process ID\tBurst Time\tTurnaround Time\tWaiting Time\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t%d\t\t%d\t\t%d\n", processes[i].id, processes[i].burst_time, processes[i].turnaround_time, processes[i].waiting_time);
    }

    return 0;
}