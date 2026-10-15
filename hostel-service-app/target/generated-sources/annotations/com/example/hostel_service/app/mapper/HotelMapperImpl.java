package com.example.hostel_service.app.mapper;

import com.example.hostel_service.app.output.entity.HotelEntity;
import com.example.hostel_service.core.model.Address;
import com.example.hostel_service.core.model.ArrivalTime;
import com.example.hostel_service.core.model.Contacts;
import com.example.hostel_service.core.model.Hotel;
import com.example.hostel_service.dto.HotelCreateRequest;
import com.example.hostel_service.dto.HotelFull;
import com.example.hostel_service.dto.HotelSummary;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-15T15:13:27+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Override
    public HotelSummary toHotelSummary(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        String phone = null;
        Long id = null;
        String name = null;
        String description = null;

        phone = hotelContactsPhone( hotel );
        id = hotel.getId();
        name = hotel.getName();
        description = hotel.getDescription();

        String address = hotel.getAddress().formatted();

        HotelSummary hotelSummary = new HotelSummary( id, name, description, address, phone );

        return hotelSummary;
    }

    @Override
    public List<HotelSummary> toListHotelSummary(List<Hotel> hotels) {
        if ( hotels == null ) {
            return null;
        }

        List<HotelSummary> list = new ArrayList<HotelSummary>( hotels.size() );
        for ( Hotel hotel : hotels ) {
            list.add( toHotelSummary( hotel ) );
        }

        return list;
    }

    @Override
    public List<Hotel> toListHotel(List<HotelEntity> listEntity) {
        if ( listEntity == null ) {
            return null;
        }

        List<Hotel> list = new ArrayList<Hotel>( listEntity.size() );
        for ( HotelEntity hotelEntity : listEntity ) {
            list.add( toHotel( hotelEntity ) );
        }

        return list;
    }

    @Override
    public Hotel toHotel(HotelEntity hotel) {
        if ( hotel == null ) {
            return null;
        }

        Hotel hotel1 = new Hotel();

        hotel1.setId( hotel.getId() );
        hotel1.setName( hotel.getName() );
        hotel1.setDescription( hotel.getDescription() );
        hotel1.setBrand( hotel.getBrand() );
        hotel1.setAddress( hotel.getAddress() );
        hotel1.setContacts( hotel.getContacts() );
        hotel1.setArrivalTime( hotel.getArrivalTime() );
        Set<String> set = hotel.getAmenities();
        if ( set != null ) {
            hotel1.setAmenities( new LinkedHashSet<String>( set ) );
        }

        return hotel1;
    }

    @Override
    public HotelEntity toEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotel.getId() );
        hotelEntity.setName( hotel.getName() );
        hotelEntity.setDescription( hotel.getDescription() );
        hotelEntity.setBrand( hotel.getBrand() );
        hotelEntity.setAddress( hotel.getAddress() );
        hotelEntity.setContacts( hotel.getContacts() );
        hotelEntity.setArrivalTime( hotel.getArrivalTime() );
        Set<String> set = hotel.getAmenities();
        if ( set != null ) {
            hotelEntity.setAmenities( new LinkedHashSet<String>( set ) );
        }

        return hotelEntity;
    }

    @Override
    public Hotel toHotel(HotelCreateRequest request) {
        if ( request == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setAddress( hotelCreateRequestToAddress( request ) );
        hotel.setContacts( hotelCreateRequestToContacts( request ) );
        hotel.setArrivalTime( hotelCreateRequestToArrivalTime( request ) );
        hotel.setName( request.name() );
        hotel.setDescription( request.description() );
        hotel.setBrand( request.brand() );

        return hotel;
    }

    @Override
    public HotelFull toHotelFull(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;
        String brand = null;
        HotelFull.Address address = null;
        HotelFull.Contacts contacts = null;
        HotelFull.ArrivalTime arrivalTime = null;
        Set<String> amenities = null;

        id = hotel.getId();
        name = hotel.getName();
        description = hotel.getDescription();
        brand = hotel.getBrand();
        address = addressToAddress( hotel.getAddress() );
        contacts = contactsToContacts( hotel.getContacts() );
        arrivalTime = arrivalTimeToArrivalTime( hotel.getArrivalTime() );
        Set<String> set = hotel.getAmenities();
        if ( set != null ) {
            amenities = new LinkedHashSet<String>( set );
        }

        HotelFull hotelFull = new HotelFull( id, name, description, brand, address, contacts, arrivalTime, amenities );

        return hotelFull;
    }

    private String hotelContactsPhone(Hotel hotel) {
        Contacts contacts = hotel.getContacts();
        if ( contacts == null ) {
            return null;
        }
        return contacts.getPhone();
    }

    protected Address hotelCreateRequestToAddress(HotelCreateRequest hotelCreateRequest) {
        if ( hotelCreateRequest == null ) {
            return null;
        }

        Address address = new Address();

        address.setHouseNumber( hotelCreateRequest.houseNumber() );
        address.setStreet( hotelCreateRequest.street() );
        address.setCity( hotelCreateRequest.city() );
        address.setCountry( hotelCreateRequest.country() );
        address.setPostCode( hotelCreateRequest.postCode() );

        return address;
    }

    protected Contacts hotelCreateRequestToContacts(HotelCreateRequest hotelCreateRequest) {
        if ( hotelCreateRequest == null ) {
            return null;
        }

        Contacts contacts = new Contacts();

        contacts.setPhone( hotelCreateRequest.phone() );
        contacts.setEmail( hotelCreateRequest.email() );

        return contacts;
    }

    protected ArrivalTime hotelCreateRequestToArrivalTime(HotelCreateRequest hotelCreateRequest) {
        if ( hotelCreateRequest == null ) {
            return null;
        }

        ArrivalTime arrivalTime = new ArrivalTime();

        arrivalTime.setCheckIn( hotelCreateRequest.checkIn() );
        arrivalTime.setCheckOut( hotelCreateRequest.checkOut() );

        return arrivalTime;
    }

    protected HotelFull.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        Integer houseNumber = null;
        String street = null;
        String city = null;
        String country = null;
        String postCode = null;

        houseNumber = address.getHouseNumber();
        street = address.getStreet();
        city = address.getCity();
        country = address.getCountry();
        postCode = address.getPostCode();

        HotelFull.Address address1 = new HotelFull.Address( houseNumber, street, city, country, postCode );

        return address1;
    }

    protected HotelFull.Contacts contactsToContacts(Contacts contacts) {
        if ( contacts == null ) {
            return null;
        }

        String phone = null;
        String email = null;

        phone = contacts.getPhone();
        email = contacts.getEmail();

        HotelFull.Contacts contacts1 = new HotelFull.Contacts( phone, email );

        return contacts1;
    }

    protected HotelFull.ArrivalTime arrivalTimeToArrivalTime(ArrivalTime arrivalTime) {
        if ( arrivalTime == null ) {
            return null;
        }

        LocalTime checkIn = null;
        LocalTime checkOut = null;

        checkIn = arrivalTime.getCheckIn();
        checkOut = arrivalTime.getCheckOut();

        HotelFull.ArrivalTime arrivalTime1 = new HotelFull.ArrivalTime( checkIn, checkOut );

        return arrivalTime1;
    }
}
