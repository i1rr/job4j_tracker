package ru.job4j.search;

import java.util.LinkedList;

/**
 * Simple priority queue class wth FIFO(first in - first out)principle.
 * @author i1rr
 * @version 1.0
 */
public class PriorityQueue {

    /**
     * No description required.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * This method puts a task into the queue.
     * If there are 2 same priority tasks then they using FIFO principle
     * to get into the queue.
     * @param task used as input task for the queue.
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * This method gets first task in the queue.
     * @return - gets back the first task from the queue or "null" if queue is empty.
     */
    public Task take() {
        return tasks.poll();
    }
}