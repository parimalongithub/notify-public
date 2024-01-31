package com.example.notify.Entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiDataResponse {
    private SearchMetadata search_metadata;
    private String id;
    private SearchParameters search_parameters;
    private SearchInformation search_information;
    private List<EventsResult> events_results;
    private String more_events_link;

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchMetadata {
        private String id;
        private String status;
        private String json_endpoint;
        private String created_at;
        private String processed_at;
        private String google_events_url;
        private String raw_html_file;
        private double total_time_taken;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchParameters {
        private String q;
        private String engine;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SearchInformation {
        private String events_results_state;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EventsResult {
        private String title;
        private EventDate date;
        private List<String> address;
        private String link;
        private String description;
        private List<TicketInfo> ticket_info;
        private Venue venue;
        private String thumbnail;
        private String image;

    @Override
    public String toString() {
        return "EventsResult{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", address=" + address +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", ticket_info=" + ticket_info +
                ", venue=" + venue +
                ", thumbnail='" + thumbnail + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

       
     
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EventDate {
        private String start_date;
        private String when;

        @Override
        public String toString() {
            return 
                     "" + start_date ;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TicketInfo {
        private String source;
        private String link;
        private String link_type;

        @Override
        public String toString() {
            return "TicketInfo{" +
                    "source='" + source + '\'' +
                    ", link='" + link + '\'' +
                    ", link_type='" + link_type + '\'' +
                    '}';
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Venue {
        private String name;
        private double rating;
        private int reviews;
        private String link;
    }
}
