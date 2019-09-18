package com.bhambhani.fashion.gallery.model;

public class SearchProduct {

  private int paginationStart;
  private int paginationEnd;
  private String sortBy;
  private String searchBy;

  public int getPaginationStart() {
    return paginationStart;
  }

  public void setPaginationStart(int paginationStart) {
    this.paginationStart = paginationStart;
  }

  public int getPaginationEnd() {
    return paginationEnd;
  }

  public void setPaginationEnd(int paginationEnd) {
    this.paginationEnd = paginationEnd;
  }

  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  public String getSearchBy() {
    return searchBy;
  }

  public void setSearchBy(String searchBy) {
    this.searchBy = searchBy;
  }

  @Override
  public String toString() {
    return "SearchProduct{" +
        "paginationStart=" + paginationStart +
        ", paginationEnd=" + paginationEnd +
        ", sortBy='" + sortBy + '\'' +
        ", searchBy='" + searchBy + '\'' +
        '}';
  }
}
