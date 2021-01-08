# WorkManager

## What's the Work Manager?

WorkManager is an API that makes it easy to schedule deferrable, asynchronous tasks that are expected to run even if the app exits or the device restarts. The WorkManager API is a suitable and recommended replacement for all previous Android background scheduling APIs, including FirebaseJobDispatcher, GcmNetworkManager, and Job Scheduler. WorkManager incorporates the features of its predecessors in a modern, consistent API that works back to API level 14 while also being conscious of battery life.

Under the hood WorkManager uses an underlying job dispatching service based on the following criteria:

![overview-criteria](https://user-images.githubusercontent.com/32849662/104047564-e3c1da80-51f2-11eb-8273-e4c8c0c7c60d.png)

## Features
In addition to providing a simpler and consistent API, WorkManager has a number of other key benefits, including:

-- Work Constraints

Declaratively define the optimal conditions for your work to run using Work Constraints. (For example, run only when the device is Wi-Fi, when the device idle, or when it has sufficient storage space, etc.)

-- Robust Scheduling

WorkManager allows you to schedule work to run one- time or repeatedly using flexible scheduling windows. Work can be tagged and named as well, allowing you to schedule unique, replaceable work and monitor or cancel groups of work together. Scheduled work is stored in an internally managed SQLite database and WorkManager takes care of ensuring that this work persists and is rescheduled across device reboots. In addition, WorkManager adheres to power-saving features and best practices like Doze mode, so you don’t have to worry about it.

-- Flexible Retry Policy

Sometimes work fails. WorkManager offers flexible retry policies, including a configurable exponential backoff policy.

-- Work Chaining

For complex related work, chain individual work tasks together using a fluent, natural, interface that allows you to control which pieces run sequentially and which run in parallel.


## The Processes

1)Define Work 

2)Create WorkRequest

3)Schedule One Time or Periodic WorkRequest

4)Effect your constraints on your work

5)Status for your work

6)Observing and chaning your work

Mor Information : https://developer.android.com/topic/libraries/architecture/workmanager/basics




