package com.example.poopwithme;

import android.net.Uri;

import com.google.gson.Gson;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;


public class AmenitiesUtils {
//    static String bathroomsNY = "{'data': [\n" +
//            "  {\n" +
//            "    'X': -105.2866207,\n" +
//            "    'Y': 40.0287556,\n" +
//            "    'Name': 'North Boulder Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (seasonal)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 1,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open from middle of May though middle of October',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.222998,\n" +
//            "    'Y': 39.9924988,\n" +
//            "    'Name': 'East Boulder Community Park',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 2,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open June through October',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2200529,\n" +
//            "    'Y': 39.992132,\n" +
//            "    'Name': 'East Boulder Community Center',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-F 5:30am - 9:30pm, Sa 7:30am - 6:00pm, Sun 9:30am - 8:00pm',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.207126,\n" +
//            "    'Y': 40.0856329,\n" +
//            "    'Name': 'Coot Lake',\n" +
//            "    'Park_Type': 'Natural Lands',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 1,\n" +
//            "    'Women': 1,\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '1x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Pit Toilet'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2056628,\n" +
//            "    'Y': 40.085798,\n" +
//            "    'Name': 'Tom Watson Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2263722,\n" +
//            "    'Y': 40.0871832,\n" +
//            "    'Name': 'Boulder Reservoir North Shore',\n" +
//            "    'Park_Type': 'Regional',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 0,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Open During Operating Hours',\n" +
//            "    'Servicing_Schedule': '2X per week in Summer, 1X per week in Winter',\n" +
//            "    'Serviced_by': 'Contractor',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2885967,\n" +
//            "    'Y': 40.0569003,\n" +
//            "    'Name': 'Foothills Community Park - North',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 4,\n" +
//            "    'Women': 4,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2874595,\n" +
//            "    'Y': 40.0548144,\n" +
//            "    'Name': 'Foothills Community Park - South',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 3,\n" +
//            "    'Women': 3,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2809739,\n" +
//            "    'Y': 40.0321615,\n" +
//            "    'Name': 'North Boulder Recreation Center',\n" +
//            "    'Park_Type': 'Public Building',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-Th 6:00-9:30, F 6:00 - 7:30, Sa 6:30-7:00, Sun 7:30-8:00',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2734986,\n" +
//            "    'Y': 40.0311634,\n" +
//            "    'Name': 'Salberg Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open from middle of May though middle of October',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2786726,\n" +
//            "    'Y': 40.0183468,\n" +
//            "    'Name': 'Pearl Street Mall',\n" +
//            "    'Park_Type': 'Regional',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 4,\n" +
//            "    'Women': 4,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '7:00am-11:00pm',\n" +
//            "    'Servicing_Schedule': '3x/day from May-Oct, then 2x /day Oct-May',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR with FAM',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2771343,\n" +
//            "    'Y': 40.0155788,\n" +
//            "    'Name': '13th St Plaza',\n" +
//            "    'Park_Type': 'Regional',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 4,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '9am- 10 pm',\n" +
//            "    'Servicing_Schedule': '3x/day May-Sep and 2x/day in winter',\n" +
//            "    'Serviced_by': 'Contractor',\n" +
//            "    'Last_Replacement_or_Enhancement': 2000,\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2812931,\n" +
//            "    'Y': 40.0138039,\n" +
//            "    'Name': 'Boulder Public Library - Main',\n" +
//            "    'Park_Type': 'Public Building',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 4,\n" +
//            "    'Women': 6,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-Th 9:00 - 8:00, F and Sa 10:00-6:00, Sun 12:00-6:00',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'Kleen Tech',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'FAM',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2959366,\n" +
//            "    'Y': 40.0128764,\n" +
//            "    'Name': 'Eben G. Fine Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 3,\n" +
//            "    'Women': 3,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.280526,\n" +
//            "    'Y': 39.9984331,\n" +
//            "    'Name': 'Chautauqua Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 4,\n" +
//            "    'Women': 4,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 7:00am until 10:00 pm',\n" +
//            "    'Servicing_Schedule': '2x/day from June through Sept, 1x/day from September to June',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2499287,\n" +
//            "    'Y': 39.9884443,\n" +
//            "    'Name': 'Martin Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open from middle of October through middle of May',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '2x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2488571,\n" +
//            "    'Y': 39.9747707,\n" +
//            "    'Name': 'South Boulder Recreation Center',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-Th 6:00-9:30, F 6:00 - 8:00, Sa and Sun 8:00- 5:00',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2513623,\n" +
//            "    'Y': 39.9726536,\n" +
//            "    'Name': 'Harlow Platts Community Park',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 1,\n" +
//            "    'Women': 1,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00pm',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2550597,\n" +
//            "    'Y': 40.0126124,\n" +
//            "    'Name': 'Scott Carpenter Park - Pool Building',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open from middle of May though middle of October',\n" +
//            "    'Hours_of_Operation': 'Follows facility hours of operation',\n" +
//            "    'Servicing_Schedule': '',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.255682,\n" +
//            "    'Y': 40.0253808,\n" +
//            "    'Name': 'East Mapleton Ball Fields',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 1,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open March 1st - Nov 1st and only accessible when fields are programmed or reserved',\n" +
//            "    'Hours_of_Operation': 'Open when fields are programmed',\n" +
//            "    'Servicing_Schedule': 'Daily when open',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2337308,\n" +
//            "    'Y': 40.0313801,\n" +
//            "    'Name': 'Valmont City Park - Bike Park',\n" +
//            "    'Park_Type': 'City Park',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2288559,\n" +
//            "    'Y': 40.0720445,\n" +
//            "    'Name': 'Boulder Reservior',\n" +
//            "    'Park_Type': 'Regional',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 3,\n" +
//            "    'Women': 6,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 4,\n" +
//            "    'Seasonal': 'Open Memorial Day to Labor Day and for Special Events',\n" +
//            "    'Hours_of_Operation': '5:30 am- 9 pm or by request for special events/picnics',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'Contractor',\n" +
//            "    'Last_Replacement_or_Enhancement': 'Painted in 2016',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2387546,\n" +
//            "    'Y': 40.0274861,\n" +
//            "    'Name': 'Valmont City Park - Disc Golf/Multi Use Field',\n" +
//            "    'Park_Type': 'City Park',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2556874,\n" +
//            "    'Y': 40.0142353,\n" +
//            "    'Name': 'Scott Carpenter Park - Ballfields',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open March 1st - Nov 1st and only accessible when fields are programmed or reserved',\n" +
//            "    'Hours_of_Operation': 'Varies',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2335028,\n" +
//            "    'Y': 40.0094148,\n" +
//            "    'Name': 'Arapahoe Ridge Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open from middle of May though end of September',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': 'Unknown',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'South Boulder Little League',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2139549,\n" +
//            "    'Y': 40.0228647,\n" +
//            "    'Name': 'Stazio Ball Fields - Phase I',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open March 1st - Nov 1st and only accessible when fields are programmed or reserved',\n" +
//            "    'Hours_of_Operation': 'Varies',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2141869,\n" +
//            "    'Y': 40.0265125,\n" +
//            "    'Name': 'Stazio Ball Fields - Phase II',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open March 1st - Nov 1st and only accessible when fields are programmed or reserved',\n" +
//            "    'Hours_of_Operation': 'Varies',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2176899,\n" +
//            "    'Y': 40.0116705,\n" +
//            "    'Name': 'Flatirons Golf Course- Hole 15',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Follows facility operating hours',\n" +
//            "    'Servicing_Schedule': 'daily',\n" +
//            "    'Serviced_by': 'BPR',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2236819,\n" +
//            "    'Y': 40.0112001,\n" +
//            "    'Name': 'Flatirons Golf Course - Hole 6',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 4,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Follows facility operating hours',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'BPR',\n" +
//            "    'Last_Replacement_or_Enhancement': 'Spring 2016',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2825403,\n" +
//            "    'Y': 39.9987352,\n" +
//            "    'Name': 'Chautauqua Park - Ranger's Cottage',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 2,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'Contractor',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'OSMP',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2526189,\n" +
//            "    'Y': 39.9844091,\n" +
//            "    'Name': 'Reynolds Library',\n" +
//            "    'Park_Type': 'Public Building',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-Th 9:00 - 8:00, F and Sa 10:00-6:00, Sun 12:00-6:00',\n" +
//            "    'Servicing_Schedule': '',\n" +
//            "    'Serviced_by': 'Kleen Tech',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'FAM',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2341264,\n" +
//            "    'Y': 39.9976872,\n" +
//            "    'Name': 'Meadows Branch Library',\n" +
//            "    'Park_Type': 'Public Building',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-Th 9:00am - 8:00pm, F and Sa 10:00am - 6:00pm, Sun 12:00pm - 6:00pm',\n" +
//            "    'Servicing_Schedule': '',\n" +
//            "    'Serviced_by': 'Kleen Tech',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'FAM',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2798796,\n" +
//            "    'Y': 40.0153559,\n" +
//            "    'Name': 'Municipal Building Restrooms',\n" +
//            "    'Park_Type': 'Public Building',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 1,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'M-F 9:00am -5:00pm',\n" +
//            "    'Servicing_Schedule': '',\n" +
//            "    'Serviced_by': 'Kleen Tech',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'FAM',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2943876,\n" +
//            "    'Y': 40.0134783,\n" +
//            "    'Name': 'Eben G. Fine Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/wk',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.280931,\n" +
//            "    'Y': 40.0141398,\n" +
//            "    'Name': 'Pilot - Boulder Creek Path - Library',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Pilot - On site for summer months',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': '4x/wk',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2870452,\n" +
//            "    'Y': 40.0285163,\n" +
//            "    'Name': 'North Boulder Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open from middle of October through middle of May',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2499515,\n" +
//            "    'Y': 39.9883518,\n" +
//            "    'Name': 'Martin Park',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (seasonal)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 1,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open from middle of May though middle of October',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.245613,\n" +
//            "    'Y': 40.0427127,\n" +
//            "    'Name': 'Pleasantview Fields',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 4,\n" +
//            "    'Women': 6,\n" +
//            "    'All': '',\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open March 1st - Nov 1st and only accessible when fields are programmed or reserved',\n" +
//            "    'Hours_of_Operation': 'Varies',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2457833,\n" +
//            "    'Y': 40.0413328,\n" +
//            "    'Name': 'Pleasantview Fields',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '2x/wk',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2824599,\n" +
//            "    'Y': 40.0140124,\n" +
//            "    'Name': 'Pilot - Boulder Creek Path - WSC',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Pilot - On site for summer months',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': '4x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.3000927,\n" +
//            "    'Y': 40.0135358,\n" +
//            "    'Name': 'Boulder Creek - Kayak Course',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open June through September',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': '4x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2550289,\n" +
//            "    'Y': 40.0128559,\n" +
//            "    'Name': 'Scott Carpenter Park - Park Restrooms',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Permanent Building (seasonal)',\n" +
//            "    'Men': 2,\n" +
//            "    'Women': 2,\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open from middle of May though middle of October',\n" +
//            "    'Hours_of_Operation': 'Generally from 5:00am until 11:00 pm. Varies as seasons change.',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'AFL Maintenance Group',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.254931,\n" +
//            "    'Y': 40.0124286,\n" +
//            "    'Name': 'Scott Carpenter Park - Portable',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2840692,\n" +
//            "    'Y': 40.0078658,\n" +
//            "    'Name': 'Colombia Cemetery',\n" +
//            "    'Park_Type': 'Neighborhood',\n" +
//            "    'Restroom_Type': 'Portable (seasonal)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '1x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2303553,\n" +
//            "    'Y': 40.0300462,\n" +
//            "    'Name': 'Valmont City Park - Dog Park',\n" +
//            "    'Park_Type': 'City Park',\n" +
//            "    'Restroom_Type': 'Portable (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': '24 hours',\n" +
//            "    'Servicing_Schedule': '3x/week',\n" +
//            "    'Serviced_by': 'United Site Services',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2201521,\n" +
//            "    'Y': 40.0113213,\n" +
//            "    'Name': 'Flatirons Pro-Shop',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': 2,\n" +
//            "    'ADA': 2,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Follows facility operating hours',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'BPR',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': ''\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2226198,\n" +
//            "    'Y': 39.9922933,\n" +
//            "    'Name': 'East Boulder Community Park',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Follows facility operating hours',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Short Term'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2831304,\n" +
//            "    'Y': 40.0145424,\n" +
//            "    'Name': 'Central Park',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Planned Year Round',\n" +
//            "    'Hours_of_Operation': 'NA',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Short Term'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2072346,\n" +
//            "    'Y': 40.0855087,\n" +
//            "    'Name': 'Coot Lake',\n" +
//            "    'Park_Type': 'Natural Lands',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Planned Year Round',\n" +
//            "    'Hours_of_Operation': 'NA',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Long Term'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2203654,\n" +
//            "    'Y': 40.0114117,\n" +
//            "    'Name': 'Flatirons Golf Course',\n" +
//            "    'Park_Type': 'Specialized Facility',\n" +
//            "    'Restroom_Type': 'In Facility',\n" +
//            "    'Men': 3,\n" +
//            "    'Women': 3,\n" +
//            "    'All': 1,\n" +
//            "    'ADA': 1,\n" +
//            "    'Seasonal': 'Open Year Round',\n" +
//            "    'Hours_of_Operation': 'Follows facility operating hours',\n" +
//            "    'Servicing_Schedule': 'Daily',\n" +
//            "    'Serviced_by': 'BPR',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Mobile Restroom Trailer'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2351618,\n" +
//            "    'Y': 40.0277623,\n" +
//            "    'Name': 'Valmont City Park South',\n" +
//            "    'Park_Type': 'City Park',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Planned Year Round',\n" +
//            "    'Hours_of_Operation': 'NA',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Long Term'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2301943,\n" +
//            "    'Y': 40.029927,\n" +
//            "    'Name': 'Valmont City Park North',\n" +
//            "    'Park_Type': 'City Park',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Planned Year Round',\n" +
//            "    'Hours_of_Operation': 'NA',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Long Term'\n" +
//            "  },\n" +
//            "  {\n" +
//            "    'X': -105.2771518,\n" +
//            "    'Y': 40.0156743,\n" +
//            "    'Name': '13th Street Plaza',\n" +
//            "    'Park_Type': 'Community',\n" +
//            "    'Restroom_Type': 'Planned Permanent (year round)',\n" +
//            "    'Men': '',\n" +
//            "    'Women': '',\n" +
//            "    'All': '',\n" +
//            "    'ADA': '',\n" +
//            "    'Seasonal': 'Planned Year Round',\n" +
//            "    'Hours_of_Operation': 'NA',\n" +
//            "    'Servicing_Schedule': 'NA',\n" +
//            "    'Serviced_by': 'NA',\n" +
//            "    'Last_Replacement_or_Enhancement': '',\n" +
//            "    'Managing_Department': 'BPR',\n" +
//            "    'Note': 'Proposed/Planned Long Term'\n" +
//            "  }\n" +
//            "]}";
    public static class row {
        public String X;
    }
    public static class test {
        public row[] data;
    }
//     throws FileNotFoundException
/*    public static Object getBathrooms() {
        Gson gson = new Gson();
        Object json;
        try {
            Log.d("results ", "  ----TRY");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            json = gson.fromJson(bufferedReader, Object.class);
        }
        catch (FileNotFoundException ex) {// insert code to run when exception occurs}
            json = null;
            Log.d("results ", "  ----CATCH");
        }

        Log.d("results ", "  -----"+json);
        return json;
    }*/
    public static double[] getLocations(int i) {
        double[][] latLongs =new double[][]{{-105.255682,40.0253808},
                {-105.2337308,40.0313801},
                {-105.2288559,40.0720445}};
        Log.d("latLong ", " "+ Arrays.deepToString(latLongs));
        return latLongs[i];
    }
}
