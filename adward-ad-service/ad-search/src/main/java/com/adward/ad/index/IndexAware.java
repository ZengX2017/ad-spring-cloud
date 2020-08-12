package com.adward.ad.index;

/**
 * @author Adward_Z
 * @date 2020/8/12
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);

}
