package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table( name="item" )
@Setter
@Getter
@ToString
public class Item extends BaseEntity{
   @Id
   @Column( name ="item_id" )
   @GeneratedValue( strategy = GenerationType.AUTO )
   private Long id;
	
   @Column( nullable = false, length=50 )
   private String itemNm;
	
   @Column( name="price", nullable=false)
   private int price;
	
   @Column( nullable=false)
   private int stockNumber;
   
   @Lob
   @Column(nullable=false)
   private String itemDetail;
   private ItemSellStatus itemSellStatus;
   
   public void updateItem(ItemFormDto itemFormDto) {
	   this.itemNm = itemFormDto.getItemNm();
	   this.price = itemFormDto.getPrice();
	   this.stockNumber = itemFormDto.getStockNumber();
	   this.itemDetail = itemFormDto.getItemDetail();
	   this.itemSellStatus = itemFormDto.getItemSellStatus(); 
   }
   
}
