package asos;

import java.io.Serializable;
import java.util.*;


public class Friendship implements Serializable{
    
    private long first;
    
    private long second;

    public Friendship(long first, long second) {
        this.first = first;
        this.second = second;
    }
    
    public Friendship(long first, String second) {
        this.first = first;
        this.second = Long.parseLong(second);
    }
    
    public Friendship(String first, String second) {
        this.first = Long.parseLong(first);
        this.second = Long.parseLong(second);
    }
    
    public Friendship(){}
    

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (Objects.hashCode(first) + Objects.hashCode(second));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Friendship other = (Friendship) obj;
        
        if (this.first == other.first) {
            return this.second == other.second;
        }

        if (this.first == other.second) {
            return this.second == other.first;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return first + " + " + second;
    }
    
    
   
}
