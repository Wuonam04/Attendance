package org.example;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
public class Stream implements Serializable {
    
    //@Entity

        public Stream() {
        }

        public Stream(String name) {
            this.name = name;
        };

        @Id //system knows that is the id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }

