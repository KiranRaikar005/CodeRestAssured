package Pojo;

import java.util.List;

public class Products 


{
	
	 private int id;
	    private String title;
	    private double price;
	    private String description;
	    private List<String> images;
	    private String creationAt;
	    private String updatedAt;
	    private Category category;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<String> getImages() {
			return images;
		}
		public void setImages(List<String> images) {
			this.images = images;
		}
		public String getCreationAt() {
			return creationAt;
		}
		public void setCreationAt(String creationAt) {
			this.creationAt = creationAt;
		}
		public String getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(String updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}

}
