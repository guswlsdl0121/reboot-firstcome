package com.hyunjin.firstcome_system.wishlist.service;

import com.hyunjin.firstcome_system.member.entity.Member;
import com.hyunjin.firstcome_system.member.usecase.MemberFinder;
import com.hyunjin.firstcome_system.product.entity.Product;
import com.hyunjin.firstcome_system.product.usecase.ProductFinder;
import com.hyunjin.firstcome_system.wishlist.dto.internal.WishlistPaging;
import com.hyunjin.firstcome_system.wishlist.dto.request.WishlistUpdateType;
import com.hyunjin.firstcome_system.wishlist.dto.response.WishlistItemDTO;
import com.hyunjin.firstcome_system.wishlist.dto.response.WishlistMainResponse;
import com.hyunjin.firstcome_system.wishlist.dto.response.WishlistUpdateResponse;
import com.hyunjin.firstcome_system.wishlist.entity.Wishlist;
import com.hyunjin.firstcome_system.wishlist.usecase.WishlistAppender;
import com.hyunjin.firstcome_system.wishlist.usecase.WishlistModifier;
import com.hyunjin.firstcome_system.wishlist.usecase.WishlistReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {
    private final MemberFinder memberFinder;
    private final ProductFinder productFinder;
    private final WishlistAppender wishlistAppender;
    private final WishlistReader wishlistReader;
    private final WishlistModifier wishlistModifier;

    public Integer createWishList(Integer memberId, Integer productId) {
        Member member = memberFinder.fetchById(memberId);
        Product product = productFinder.fetchById(productId);

        Wishlist newWishList = wishlistAppender.validateUniqueAndSave(member, product);

        return newWishList.getId();
    }

    public WishlistMainResponse getWishList(Integer memberId, String cursor, int size) {
        Member member = memberFinder.fetchById(memberId);

        WishlistPaging result = wishlistReader.getIdsForPagination(member.getId(), cursor, size);
        List<WishlistItemDTO> wishlistItems = wishlistReader.getItemByIds(result.ids());

        return WishlistMainResponse.builder()
                .items(wishlistItems)
                .nextCursor(result.nextCursor())
                .build();
    }

    public Integer deleteWishlist(Integer wishlistId) {
        return wishlistModifier.removeWishlist(wishlistId);
    }

    public WishlistUpdateResponse updateWishlistQuantity(Integer wishlistId, WishlistUpdateType updateType) {
        Wishlist updatedWishlist = wishlistModifier.updateQuantity(wishlistId, updateType);
        return WishlistUpdateResponse.from(updatedWishlist);
    }
}
