package com.veitch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一种狗猫队列的结构，要求如下：
 * 用户可以调用add方法将cat类或dog类的实例放入队列中；
 * 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次 弹出；
 * 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
 * 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
 * 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
 * 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 *
 * @author zhengweichao  2020-07-20 6:43 下午
 **/


public class DogCatQueue {

    Queue<PetEnterQueue> dogQueue = new LinkedList<>();
    Queue<PetEnterQueue> catQueue = new LinkedList<>();

    int count = 0;

    public void add(Pet pet){

        PetEnterQueue petEnterQueue = new PetEnterQueue(pet, ++count);

        if (pet instanceof Dog) {
            dogQueue.add(petEnterQueue);
        } else if (pet instanceof Cat){
            catQueue.add(petEnterQueue);
        }

    }

    public Pet pollAll(){
        if (isEmpty()) {
            throw new RuntimeException("猫狗队列为空，不允许此操作！");
        }

        if (isDogEmpty()) {
            return pollCat();
        }


        if (isCatEmpty()) {
            return pollDog();
        }

        PetEnterQueue dogQueue = this.dogQueue.peek();
        PetEnterQueue catQueue = this.catQueue.peek();

        if (dogQueue.getCount() < catQueue.getCount()) {
            return this.dogQueue.poll().getPet();
        } else {
            return this.catQueue.poll().getPet();
        }
    }

    public Dog pollDog(){
        if (isDogEmpty()) {
            throw new RuntimeException("狗队列为空，不允许此操作！");
        }

        PetEnterQueue petEnterQueue = dogQueue.poll();

        return (Dog)petEnterQueue.getPet();
    }

    public Cat pollCat(){
        if (isCatEmpty()) {
            throw new RuntimeException("猫队列为空，不允许此操作！");
        }

        PetEnterQueue petEnterQueue = catQueue.poll();

        return (Cat)petEnterQueue.getPet();
    }

    public Boolean isEmpty(){
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public Boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public Boolean isCatEmpty(){
        return catQueue.isEmpty();
    }


    public static void main(String[] args) {

        DogCatQueue dogCatQueue = new DogCatQueue();
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Cat());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());

        System.out.println(dogCatQueue.isCatEmpty());
        System.out.println(dogCatQueue.isDogEmpty());
        System.out.println(dogCatQueue.isEmpty());

        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollCat());
        System.out.println(dogCatQueue.pollDog());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.isCatEmpty());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        System.out.println(dogCatQueue.isCatEmpty());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollAll());
        System.out.println(dogCatQueue.pollAll());

    }


}

class PetEnterQueue {

    private Pet pet;
    private Integer count;


    public PetEnterQueue(Pet pet, Integer count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return pet;
    }

    public Integer getCount(){
        return count;
    }



}


class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat() {
        super("cat");
    }
}