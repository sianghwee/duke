# User Guide
This is a simple user guide for the Duke application that was forked from [nus-cs2103-AY1920S1/duke](https://github.com/nus-cs2103-AY1920S1/duke). Listed below are some of the features and the keywords for the usage of the application.

## Features 

### Feature 1 - Variety of Tasks
In this application, there are three kind of tasks that can be implemented:
1. **todo** - a task that needs to be done but there is no deadline to it
2. **deadline** - a task that needs to be done and there is a deadline to it
3. **event** - a task that has a date in which it is happening

A task is expressed in the form [type][status][priority] description.
The tasks can be differentiated based on the type of the task [X] where X is T/D/E respectively.

### Feature 2 - Mark a task as done
For all the tasks that are in this application, they can be marked as done when they are completed. 
This is to help the user keep track of the tasks that they have and make sure that they are on track with their tasks. 
A task is marked as complete when its status is an O and incomplete when status is a X. By default, when a task is added,
the status is incomplete[X].

### Feature 3 - Priority of a task
For all the tasks that are in this application, they can also have different priority level allocated by the user. 
This is to aid the user in identifying the more urgent tasks so that they are able to prioritise their schedule and do 
the tasks that are of a higher priority first. The priority of a task can be seen from the [priority] part of the task
expression. It is represented by a letter H/M/L to represent high/medium/low respectively. By default, all task when 
added has a priority of medium[M].

### Feature 4 - Smart date
For tasks such as deadline and event, they require a date or time. For this application, a date or time can be passed into
the task in two formats:
1. a string representation of the date (e.g. tmr 1pm, midnight on Monday)
2. a date in the format <DD/MM/YY HHMM>. This will be converted to a format **\<date> of \<month> \<year>, \<time>**.

The two formats will give the user of the application more freedom in terms of choosing how they want to represent
the date. The date will be displayed after the description of the task.

### Feature 5 - Finding a task
The application allows for one to search for a task by their description. This is to help users who have a lot of tasks
on their list and would like to search for a specific task. To allow editting of the task, the index of the task when searched
will be the actual index of the task so that all the other commands will still be able to work on it.

### Feature 6 - Deleting a task
A task can be deleted from the list if it is no longer relevant to the user or there is an error with the task expression. Once
a task is deleted, the index of all the task after it is moved up.

## Usage

### `Keyword` - Describe action

Describe action and its outcome.

Example of usage: 

`keyword (optional arguments)`

Expected outcome:

`outcome`
