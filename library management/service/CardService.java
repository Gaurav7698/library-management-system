package com.sctpl.admin.g1.library123.service;

import com.sctpl.admin.g1.library123.domain.Card;

import java.util.List;

public interface CardService {
    Card saveCard(Card libraryCard);

    Card fetchById(Integer cardId);

    List<Card> fetchAll();

    Card update(Card libraryCard);

}
