package com.example.MOERADTEACHER.common.transferbean;

import java.util.Date;

public class Transfer {
	
	
    private String station;
    private Date startDate;
    private Date endDate;
    int noOfDays;
    int rowNumber;
    private String groundForTransfer;
    int id3;

    public Transfer(String station, Date startDate, Date endDate, int noOfDays,String groundForTransfer,Integer id3) {
        this.station = station;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDays= noOfDays;
        this.groundForTransfer=groundForTransfer;
        this.id3=id3;
    }

    public String getStation() {
        return station;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

public int getNoOfDays() {
return noOfDays;
}

public int getRowNumber() {
return rowNumber;
}

public String getGroundForTransfer() {
	return groundForTransfer;
}

public int getId3() {
	return id3;
}



}
