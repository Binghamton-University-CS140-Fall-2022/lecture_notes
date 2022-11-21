----------------
The System Class
----------------

- The `System` class contains fields and methods to interact with the system
- It has three `static` stream fields
	- `System.err` - `PrintStream` for standard error
	- `System.in` - `InputStream` for standard input
	- `System.out` - `PrintStream` for standard output

## Redirecting the streams via java executable

- When you are running a program, you can ***redirect*** input to standard input and output from standard output and standard error

``` java
java java_program_name < input.txt > output.txt 2> error.txt
```
- Any reads from ***standard input*** will be read from the file `input.txt`
- Any writes to ***standard output*** will be written to the file `output.txt`
- Any writes to ***standard error*** will be written to the file `error.txt`

## System - static methods

- The `System` class also has a collection of `static` methods

| Static method | Description |
| ------------- | ----------- |
| currentTimeMillis() | The current time in milliseconds. More specifically, the number of milliseconds that have elapsed since midnight, 1/1/1970 UTC. I typically use this to determine delta times. |
| nanoTime() | Current value of the virtual machine's high resolution time source in nanoseconds. Only used for deltas times. The time resolution is guarenteed to be at least as good as `currentTimeMillis()`. The returned value is in nanoseconds, but the time resolution is not guaranteed to be in nanoseconds. |
| exit(int exitStatus) | Terminates the virtual machine. The parameter is the status code, non zero values are considered an abnormal termination. |
| gc() | Runs the garbage collector for the virtual machine. Attempts to return memory that is no longer used. |
| Map<String, String> getEnv() | Returns a string map view of the current system environment. |
| Properties.getProperties() | Returns the current system properties. Properites can be updated via `setProperty()` or `setProperties()` |

- There are other mehtods as well