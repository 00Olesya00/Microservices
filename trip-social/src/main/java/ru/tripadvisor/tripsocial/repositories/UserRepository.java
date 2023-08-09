package ru.tripadvisor.tripsocial.repositories;
import org.springframework.data.repository.CrudRepository;
import ru.tripadvisor.tripsocial.entities.User;

    public interface UserRepository extends CrudRepository<User, Long> {

    }

