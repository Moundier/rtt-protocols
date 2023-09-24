# Project Round Trip Time

### Abbreviations and Acronyms
* **CALC**: Calculate
* **RTT**: Round Trip Time 

### Abstract
* Two timers are involved in measuring the RTT.
* Timer 1 starts when the client sends a "Ping" request.
* Timer 2 stops when the server sends a "Pong" response.
* The RTT is then calculated as the difference between (Timer 2's stop time) and (Timer 1's start time), divided by 2.
* RTT represents the time it takes for data to travel from the client to the server and back to the client.

### Research Objectives
* Calc TCP RTT in a Client Server Architecture
* Calc UDP RTT in a Client Server Architecture
* Provide which Architecture is the faster one

### Conclusion
TCP overhead is primarily caused by the additional control information and mechanisms it uses to ensure reliable and ordered data transmission. And this is what they call a connection.

UDP, a connectionless protocol, is faster than TCP because it doesn't establish a connection before sending data, which reduces overhead but can lead to less reliable communication.

### Made with
* Java
* Maven