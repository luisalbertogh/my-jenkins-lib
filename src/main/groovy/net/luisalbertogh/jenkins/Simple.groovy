package net.luisalbertogh.jenkins

/*
class Simple implements Serializable {
    String name

    String toString() {
        return name
    }
} */

def sayHello(name){
	echo "Hello " + name + " from simple lib"
}

