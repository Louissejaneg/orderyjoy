package com.louissegarcia.orderyjoy.NotFoundException;

public class UsersNotFoundException extends RuntimeException {
public UsersNotFoundException(Long id){
    super("Could not found users with " + id);
}
}
