package service;

import model.Root;

public interface JsonService {

    Root parse();
    Root changePlaces();

    Root playCommands();
}
