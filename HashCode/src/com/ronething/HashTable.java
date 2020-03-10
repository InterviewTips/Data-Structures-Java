package com.ronething;

import java.util.TreeMap;

public class HashTable<K extends Comparable<K>, V> {

    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private final static int upperTol = 10;
    private final static int lowerTol = 2;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    private int capacityIndex = 0;

    public HashTable() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        this.hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacityIndex);
            }
        }
    }

    public V remove(K key) {
        V value = null;
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            value = map.remove(key);
            size--;
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacityIndex);
            }
        }
        return value;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("error key");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int capacityIndex) {
        int oldM = M;
        int newM = capacity[capacityIndex];
        this.M = newM;
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        for (int i = 0; i < oldM; i++) {
            // 注：这里不能简单赋值 newHashTable[i] = hashTable[i]
            // 因为 hash(K key) 方法中的 M 变了，key 算出来的哈希值会变
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        hashTable = newHashTable;
    }

}
