package com.test.sicredi.fixture;


import com.test.sicredi.dto.ItemDTO;

public class ItemDTOFixture {

    private static ItemDTO buildRandom() {
        ItemDTO itemDTO = new ItemDTO(
                1l,
                2,
                "nome Produto"
        );
        return itemDTO;

    }

    public static ItemDTO build() {
        return buildRandom();
    }

}
