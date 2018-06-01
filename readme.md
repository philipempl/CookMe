# Collapsed Social Network 

... is a social network for people who don't need one. It combines all advantages of established social networks and merge them into one neutral framework.
Main advantages: 
* Go in privacy (you can not receive any text messages or request at time)
* Get reminded to your friends birthday to stay in touch and be a good friends
* Easy built in request manager for an easy connection and time management with your friends
* Store your important pictures remotely and categorized on your device
* Never lose documents anymore
* Join activities your friends do at the moment and never miss any event

## Getting Started

### Installing

Installing [Couchbase](https://developer.couchbase.com/documentation/server/current/install/install-package-windows.html) and [Docker](https://www.docker.com/community-edition) to run system on your device.
Developing is done with [Android Studio](https://developer.android.com/studio/)

### Configuration

Configure the pre-named software by their published manuals. 

Explain how to run the automated tests for this system

### Docker Command Line

Docker is using images and an running image is representing a container.

List all images

* $ docker images -a

List all container

* $ docker ps -a

Remove images

* $ docker rmi *name*

Remove container

* $ docker rm *containerID*

Stop container 

** $ docker stop *containerID*
** $ docker rm $(docker kill $(docker ps -aq))

Run new container

* $ docker run -d -p 8091-8093:8091-8093 -p 11210:11210 *imageNmae*

Start existing container

* $ docker start *containerID*

## Deployment

Ensure that Docker is already running.
Then open command line an insert:

* $ docker start 4bf16c2553b5

After that, the UI is reachable under [LocalHost] (http://localhost:8091/ui/index.html)

If there have been made any changes to the container, please commit these changes under by running the following command:

* $ docker commit 4bf16c2553b5 rhel-http

Run the Android emulator

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Gradle](https://gradle.org/) - Used to build the Application


## Authors

* **Philip Empl** - *Initial WOrk* - [Philip Empl](https://github.com/philipempl)


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
