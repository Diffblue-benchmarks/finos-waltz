package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Component;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.Entry;
import org.finos.waltz.model.ImmutableEntry;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.helpers.SubstituteLogger;
import spark.Request;
import spark.Response;

@ExtendWith(MockitoExtension.class)
class WebUtilitiesDiffblueTest {
  @InjectMocks
  private WebUtilities webUtilities;

  /**
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  void testMkPath() {
    // Arrange, Act and Assert
    assertEquals("Segs", WebUtilities.mkPath("Segs"));
    assertEquals("/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
    assertEquals("/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/", WebUtilities.mkPath("/", "/"));
    assertEquals("/: Array was null", WebUtilities.mkPath("/", ": Array was null"));
    assertEquals("/: Predicate was null", WebUtilities.mkPath("/", ": Predicate was null"));
    assertEquals("/Array must be provided", WebUtilities.mkPath("/", "Array must be provided"));
    assertEquals("/Predicate must be provided", WebUtilities.mkPath("/", "Predicate must be provided"));
    assertEquals("/Segs", WebUtilities.mkPath("/", "Segs"));
    assertEquals("/ttf", WebUtilities.mkPath("/", "ttf"));
    assertEquals("/42", WebUtilities.mkPath("/", "42"));
    assertEquals("/+", WebUtilities.mkPath("/", "/+"));
    assertEquals("/yyyy-MM-dd", WebUtilities.mkPath("/", "yyyy-MM-dd"));
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/"));
    assertEquals(": Array was null/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/"));
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/"));
    assertEquals("Segs/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/"));
    assertEquals("ttf/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/"));
    assertEquals("42/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/+/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/"));
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/"));
    assertEquals("/", WebUtilities.mkPath("/", "/", "/"));
    assertEquals("/: Array was null/", WebUtilities.mkPath("/", ": Array was null", "/"));
    assertEquals("/: Predicate was null/", WebUtilities.mkPath("/", ": Predicate was null", "/"));
    assertEquals("/Array must be provided/", WebUtilities.mkPath("/", "Array must be provided", "/"));
    assertEquals("/Predicate must be provided/", WebUtilities.mkPath("/", "Predicate must be provided", "/"));
    assertEquals("/Segs/", WebUtilities.mkPath("/", "Segs", "/"));
    assertEquals("/ttf/", WebUtilities.mkPath("/", "ttf", "/"));
    assertEquals("/42/", WebUtilities.mkPath("/", "42", "/"));
    assertEquals("/+/", WebUtilities.mkPath("/", "/+", "/"));
    assertEquals("/yyyy-MM-dd/", WebUtilities.mkPath("/", "yyyy-MM-dd", "/"));
    assertEquals("/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path"));
    assertEquals("/Cannot convert empty or null segments to path/: Array was null",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Array was null"));
    assertEquals("/Cannot convert empty or null segments to path/: Predicate was null",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Predicate was null"));
    assertEquals("/Cannot convert empty or null segments to path/Array must be provided",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Array must be provided"));
    assertEquals("/Cannot convert empty or null segments to path/Predicate must be provided",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Predicate must be provided"));
    assertEquals("/Cannot convert empty or null segments to path/Segs",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs"));
    assertEquals("/Cannot convert empty or null segments to path/ttf",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "ttf"));
    assertEquals("/Cannot convert empty or null segments to path/42",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42"));
    assertEquals("/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/Cannot convert empty or null segments to path/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "yyyy-MM-dd"));
    assertEquals("Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
    assertEquals(": Array was null/", WebUtilities.mkPath(": Array was null", "/"));
    assertEquals(": Predicate was null/", WebUtilities.mkPath(": Predicate was null", "/"));
    assertEquals("Array must be provided/", WebUtilities.mkPath("Array must be provided", "/"));
    assertEquals("Predicate must be provided/", WebUtilities.mkPath("Predicate must be provided", "/"));
    assertEquals("Segs/", WebUtilities.mkPath("Segs", "/"));
    assertEquals("ttf/", WebUtilities.mkPath("ttf", "/"));
    assertEquals("42/", WebUtilities.mkPath("42", "/"));
    assertEquals("/+/", WebUtilities.mkPath("/+", "/"));
    assertEquals("yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "/"));
    assertEquals("Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Array was null/+", WebUtilities.mkPath(": Array was null", "/+"));
    assertEquals(": Predicate was null/+", WebUtilities.mkPath(": Predicate was null", "/+"));
    assertEquals("Array must be provided/+", WebUtilities.mkPath("Array must be provided", "/+"));
    assertEquals("Predicate must be provided/+", WebUtilities.mkPath("Predicate must be provided", "/+"));
    assertEquals("Segs/+", WebUtilities.mkPath("Segs", "/+"));
    assertEquals("ttf/+", WebUtilities.mkPath("ttf", "/+"));
    assertEquals("42/+", WebUtilities.mkPath("42", "/+"));
    assertEquals("/+/+", WebUtilities.mkPath("/+", "/+"));
    assertEquals("yyyy-MM-dd/+", WebUtilities.mkPath("yyyy-MM-dd", "/+"));
    assertEquals("Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/"));
    assertEquals("Cannot convert empty or null segments to path/: Array was null/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", ": Array was null", "/"));
    assertEquals("Cannot convert empty or null segments to path/: Predicate was null/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", ": Predicate was null", "/"));
    assertEquals("Cannot convert empty or null segments to path/Array must be provided/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Array must be provided", "/"));
    assertEquals("Cannot convert empty or null segments to path/Predicate must be provided/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Predicate must be provided", "/"));
    assertEquals("Cannot convert empty or null segments to path/Segs/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/"));
    assertEquals("Cannot convert empty or null segments to path/ttf/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "ttf", "/"));
    assertEquals("Cannot convert empty or null segments to path/42/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/"));
    assertEquals("Cannot convert empty or null segments to path/+/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/"));
    assertEquals("Cannot convert empty or null segments to path/yyyy-MM-dd/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "yyyy-MM-dd", "/"));
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Array was null/", WebUtilities.mkPath(": Array was null", "/", "/"));
    assertEquals(": Array was null/: Array was null/",
        WebUtilities.mkPath(": Array was null", ": Array was null", "/"));
    assertEquals(": Array was null/: Predicate was null/",
        WebUtilities.mkPath(": Array was null", ": Predicate was null", "/"));
    assertEquals(": Array was null/Array must be provided/",
        WebUtilities.mkPath(": Array was null", "Array must be provided", "/"));
    assertEquals(": Array was null/Predicate must be provided/",
        WebUtilities.mkPath(": Array was null", "Predicate must be provided", "/"));
    assertEquals(": Array was null/Segs/", WebUtilities.mkPath(": Array was null", "Segs", "/"));
    assertEquals(": Array was null/ttf/", WebUtilities.mkPath(": Array was null", "ttf", "/"));
    assertEquals(": Array was null/42/", WebUtilities.mkPath(": Array was null", "42", "/"));
    assertEquals(": Array was null/+/", WebUtilities.mkPath(": Array was null", "/+", "/"));
    assertEquals(": Array was null/yyyy-MM-dd/", WebUtilities.mkPath(": Array was null", "yyyy-MM-dd", "/"));
    assertEquals(": Array was null/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/+"));
    assertEquals(": Predicate was null/", WebUtilities.mkPath(": Predicate was null", "/", "/"));
    assertEquals(": Predicate was null/: Array was null/",
        WebUtilities.mkPath(": Predicate was null", ": Array was null", "/"));
    assertEquals(": Predicate was null/: Predicate was null/",
        WebUtilities.mkPath(": Predicate was null", ": Predicate was null", "/"));
    assertEquals(": Predicate was null/Array must be provided/",
        WebUtilities.mkPath(": Predicate was null", "Array must be provided", "/"));
    assertEquals(": Predicate was null/Predicate must be provided/",
        WebUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/"));
    assertEquals(": Predicate was null/Segs/", WebUtilities.mkPath(": Predicate was null", "Segs", "/"));
    assertEquals(": Predicate was null/ttf/", WebUtilities.mkPath(": Predicate was null", "ttf", "/"));
    assertEquals(": Predicate was null/42/", WebUtilities.mkPath(": Predicate was null", "42", "/"));
    assertEquals(": Predicate was null/+/", WebUtilities.mkPath(": Predicate was null", "/+", "/"));
    assertEquals(": Predicate was null/yyyy-MM-dd/", WebUtilities.mkPath(": Predicate was null", "yyyy-MM-dd", "/"));
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Array must be provided/", WebUtilities.mkPath("Array must be provided", "/", "/"));
    assertEquals("Array must be provided/: Array was null/",
        WebUtilities.mkPath("Array must be provided", ": Array was null", "/"));
    assertEquals("Array must be provided/: Predicate was null/",
        WebUtilities.mkPath("Array must be provided", ": Predicate was null", "/"));
    assertEquals("Array must be provided/Array must be provided/",
        WebUtilities.mkPath("Array must be provided", "Array must be provided", "/"));
    assertEquals("Array must be provided/Predicate must be provided/",
        WebUtilities.mkPath("Array must be provided", "Predicate must be provided", "/"));
    assertEquals("Array must be provided/Segs/", WebUtilities.mkPath("Array must be provided", "Segs", "/"));
    assertEquals("Array must be provided/ttf/", WebUtilities.mkPath("Array must be provided", "ttf", "/"));
    assertEquals("Array must be provided/42/", WebUtilities.mkPath("Array must be provided", "42", "/"));
    assertEquals("Array must be provided/+/", WebUtilities.mkPath("Array must be provided", "/+", "/"));
    assertEquals("Array must be provided/yyyy-MM-dd/",
        WebUtilities.mkPath("Array must be provided", "yyyy-MM-dd", "/"));
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Predicate must be provided/", WebUtilities.mkPath("Predicate must be provided", "/", "/"));
    assertEquals("Predicate must be provided/: Array was null/",
        WebUtilities.mkPath("Predicate must be provided", ": Array was null", "/"));
    assertEquals("Predicate must be provided/: Predicate was null/",
        WebUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/"));
    assertEquals("Predicate must be provided/Array must be provided/",
        WebUtilities.mkPath("Predicate must be provided", "Array must be provided", "/"));
    assertEquals("Predicate must be provided/Predicate must be provided/",
        WebUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/"));
    assertEquals("Predicate must be provided/Segs/", WebUtilities.mkPath("Predicate must be provided", "Segs", "/"));
    assertEquals("Predicate must be provided/ttf/", WebUtilities.mkPath("Predicate must be provided", "ttf", "/"));
    assertEquals("Predicate must be provided/42/", WebUtilities.mkPath("Predicate must be provided", "42", "/"));
    assertEquals("Predicate must be provided/+/", WebUtilities.mkPath("Predicate must be provided", "/+", "/"));
    assertEquals("Predicate must be provided/yyyy-MM-dd/",
        WebUtilities.mkPath("Predicate must be provided", "yyyy-MM-dd", "/"));
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("Segs/", WebUtilities.mkPath("Segs", "/", "/"));
    assertEquals("Segs/: Array was null/", WebUtilities.mkPath("Segs", ": Array was null", "/"));
    assertEquals("Segs/: Predicate was null/", WebUtilities.mkPath("Segs", ": Predicate was null", "/"));
    assertEquals("Segs/Array must be provided/", WebUtilities.mkPath("Segs", "Array must be provided", "/"));
    assertEquals("Segs/Predicate must be provided/", WebUtilities.mkPath("Segs", "Predicate must be provided", "/"));
    assertEquals("Segs/Segs/", WebUtilities.mkPath("Segs", "Segs", "/"));
    assertEquals("Segs/ttf/", WebUtilities.mkPath("Segs", "ttf", "/"));
    assertEquals("Segs/42/", WebUtilities.mkPath("Segs", "42", "/"));
    assertEquals("Segs/yyyy-MM-dd/", WebUtilities.mkPath("Segs", "yyyy-MM-dd", "/"));
    assertEquals("Segs/+/", WebUtilities.mkPath("Segs", "/+", "/"));
    assertEquals("Segs/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("ttf/", WebUtilities.mkPath("ttf", "/", "/"));
    assertEquals("ttf/: Array was null/", WebUtilities.mkPath("ttf", ": Array was null", "/"));
    assertEquals("ttf/: Predicate was null/", WebUtilities.mkPath("ttf", ": Predicate was null", "/"));
    assertEquals("ttf/Array must be provided/", WebUtilities.mkPath("ttf", "Array must be provided", "/"));
    assertEquals("ttf/Predicate must be provided/", WebUtilities.mkPath("ttf", "Predicate must be provided", "/"));
    assertEquals("ttf/Segs/", WebUtilities.mkPath("ttf", "Segs", "/"));
    assertEquals("ttf/ttf/", WebUtilities.mkPath("ttf", "ttf", "/"));
    assertEquals("ttf/42/", WebUtilities.mkPath("ttf", "42", "/"));
    assertEquals("ttf/yyyy-MM-dd/", WebUtilities.mkPath("ttf", "yyyy-MM-dd", "/"));
    assertEquals("ttf/+/", WebUtilities.mkPath("ttf", "/+", "/"));
    assertEquals("ttf/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("42/", WebUtilities.mkPath("42", "/", "/"));
    assertEquals("42/: Array was null/", WebUtilities.mkPath("42", ": Array was null", "/"));
    assertEquals("42/: Predicate was null/", WebUtilities.mkPath("42", ": Predicate was null", "/"));
    assertEquals("42/Array must be provided/", WebUtilities.mkPath("42", "Array must be provided", "/"));
    assertEquals("42/Predicate must be provided/", WebUtilities.mkPath("42", "Predicate must be provided", "/"));
    assertEquals("42/Segs/", WebUtilities.mkPath("42", "Segs", "/"));
    assertEquals("42/ttf/", WebUtilities.mkPath("42", "ttf", "/"));
    assertEquals("42/42/", WebUtilities.mkPath("42", "42", "/"));
    assertEquals("42/yyyy-MM-dd/", WebUtilities.mkPath("42", "yyyy-MM-dd", "/"));
    assertEquals("42/+/", WebUtilities.mkPath("42", "/+", "/"));
    assertEquals("42/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/+/", WebUtilities.mkPath("/+", "/", "/"));
    assertEquals("/+/: Array was null/", WebUtilities.mkPath("/+", ": Array was null", "/"));
    assertEquals("/+/: Predicate was null/", WebUtilities.mkPath("/+", ": Predicate was null", "/"));
    assertEquals("/+/Array must be provided/", WebUtilities.mkPath("/+", "Array must be provided", "/"));
    assertEquals("/+/Predicate must be provided/", WebUtilities.mkPath("/+", "Predicate must be provided", "/"));
    assertEquals("/+/Segs/", WebUtilities.mkPath("/+", "Segs", "/"));
    assertEquals("/+/ttf/", WebUtilities.mkPath("/+", "ttf", "/"));
    assertEquals("/+/42/", WebUtilities.mkPath("/+", "42", "/"));
    assertEquals("/+/+/", WebUtilities.mkPath("/+", "/+", "/"));
    assertEquals("/+/yyyy-MM-dd/", WebUtilities.mkPath("/+", "yyyy-MM-dd", "/"));
    assertEquals("/+/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "/", "/"));
    assertEquals("yyyy-MM-dd/: Array was null/", WebUtilities.mkPath("yyyy-MM-dd", ": Array was null", "/"));
    assertEquals("yyyy-MM-dd/: Predicate was null/", WebUtilities.mkPath("yyyy-MM-dd", ": Predicate was null", "/"));
    assertEquals("yyyy-MM-dd/Array must be provided/",
        WebUtilities.mkPath("yyyy-MM-dd", "Array must be provided", "/"));
    assertEquals("yyyy-MM-dd/Predicate must be provided/",
        WebUtilities.mkPath("yyyy-MM-dd", "Predicate must be provided", "/"));
    assertEquals("yyyy-MM-dd/Segs/", WebUtilities.mkPath("yyyy-MM-dd", "Segs", "/"));
    assertEquals("yyyy-MM-dd/ttf/", WebUtilities.mkPath("yyyy-MM-dd", "ttf", "/"));
    assertEquals("yyyy-MM-dd/42/", WebUtilities.mkPath("yyyy-MM-dd", "42", "/"));
    assertEquals("yyyy-MM-dd/yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "yyyy-MM-dd", "/"));
    assertEquals("yyyy-MM-dd/+/", WebUtilities.mkPath("yyyy-MM-dd", "/+", "/"));
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/+"));
    assertEquals("/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path"));
    assertEquals("/: Array was null", WebUtilities.mkPath("/", "/", ": Array was null"));
    assertEquals("/: Predicate was null", WebUtilities.mkPath("/", "/", ": Predicate was null"));
    assertEquals("/Array must be provided", WebUtilities.mkPath("/", "/", "Array must be provided"));
    assertEquals("/Predicate must be provided", WebUtilities.mkPath("/", "/", "Predicate must be provided"));
    assertEquals("/Segs", WebUtilities.mkPath("/", "/", "Segs"));
    assertEquals("/ttf", WebUtilities.mkPath("/", "/", "ttf"));
    assertEquals("/42", WebUtilities.mkPath("/", "/", "42"));
    assertEquals("/+", WebUtilities.mkPath("/", "/", "/+"));
    assertEquals("/yyyy-MM-dd", WebUtilities.mkPath("/", "/", "yyyy-MM-dd"));
    assertEquals("/: Array was null/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", ": Array was null", "Cannot convert empty or null segments to path"));
    assertEquals("/: Array was null/: Array was null",
        WebUtilities.mkPath("/", ": Array was null", ": Array was null"));
    assertEquals("/: Array was null/: Predicate was null",
        WebUtilities.mkPath("/", ": Array was null", ": Predicate was null"));
    assertEquals("/: Array was null/Array must be provided",
        WebUtilities.mkPath("/", ": Array was null", "Array must be provided"));
    assertEquals("/: Array was null/Predicate must be provided",
        WebUtilities.mkPath("/", ": Array was null", "Predicate must be provided"));
    assertEquals("/: Array was null/Segs", WebUtilities.mkPath("/", ": Array was null", "Segs"));
    assertEquals("/: Array was null/ttf", WebUtilities.mkPath("/", ": Array was null", "ttf"));
    assertEquals("/: Array was null/42", WebUtilities.mkPath("/", ": Array was null", "42"));
    assertEquals("/: Array was null/+", WebUtilities.mkPath("/", ": Array was null", "/+"));
    assertEquals("/: Array was null/yyyy-MM-dd", WebUtilities.mkPath("/", ": Array was null", "yyyy-MM-dd"));
    assertEquals("/: Predicate was null/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", ": Predicate was null", "Cannot convert empty or null segments to path"));
    assertEquals("/: Predicate was null/: Array was null",
        WebUtilities.mkPath("/", ": Predicate was null", ": Array was null"));
    assertEquals("/: Predicate was null/: Predicate was null",
        WebUtilities.mkPath("/", ": Predicate was null", ": Predicate was null"));
    assertEquals("/: Predicate was null/Array must be provided",
        WebUtilities.mkPath("/", ": Predicate was null", "Array must be provided"));
    assertEquals("/: Predicate was null/Predicate must be provided",
        WebUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided"));
    assertEquals("/: Predicate was null/Segs", WebUtilities.mkPath("/", ": Predicate was null", "Segs"));
    assertEquals("/: Predicate was null/ttf", WebUtilities.mkPath("/", ": Predicate was null", "ttf"));
    assertEquals("/: Predicate was null/42", WebUtilities.mkPath("/", ": Predicate was null", "42"));
    assertEquals("/: Predicate was null/+", WebUtilities.mkPath("/", ": Predicate was null", "/+"));
    assertEquals("/: Predicate was null/yyyy-MM-dd", WebUtilities.mkPath("/", ": Predicate was null", "yyyy-MM-dd"));
    assertEquals("/Array must be provided/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Array must be provided", "Cannot convert empty or null segments to path"));
    assertEquals("/Array must be provided/: Array was null",
        WebUtilities.mkPath("/", "Array must be provided", ": Array was null"));
    assertEquals("/Array must be provided/: Predicate was null",
        WebUtilities.mkPath("/", "Array must be provided", ": Predicate was null"));
    assertEquals("/Array must be provided/Array must be provided",
        WebUtilities.mkPath("/", "Array must be provided", "Array must be provided"));
    assertEquals("/Array must be provided/Predicate must be provided",
        WebUtilities.mkPath("/", "Array must be provided", "Predicate must be provided"));
    assertEquals("/Array must be provided/Segs", WebUtilities.mkPath("/", "Array must be provided", "Segs"));
    assertEquals("/Array must be provided/ttf", WebUtilities.mkPath("/", "Array must be provided", "ttf"));
    assertEquals("/Array must be provided/42", WebUtilities.mkPath("/", "Array must be provided", "42"));
    assertEquals("/Array must be provided/+", WebUtilities.mkPath("/", "Array must be provided", "/+"));
    assertEquals("/Array must be provided/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Array must be provided", "yyyy-MM-dd"));
    assertEquals("/Predicate must be provided/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Predicate must be provided", "Cannot convert empty or null segments to path"));
    assertEquals("/Predicate must be provided/: Array was null",
        WebUtilities.mkPath("/", "Predicate must be provided", ": Array was null"));
    assertEquals("/Predicate must be provided/: Predicate was null",
        WebUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null"));
    assertEquals("/Predicate must be provided/Array must be provided",
        WebUtilities.mkPath("/", "Predicate must be provided", "Array must be provided"));
    assertEquals("/Predicate must be provided/Predicate must be provided",
        WebUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided"));
    assertEquals("/Predicate must be provided/Segs", WebUtilities.mkPath("/", "Predicate must be provided", "Segs"));
    assertEquals("/Predicate must be provided/ttf", WebUtilities.mkPath("/", "Predicate must be provided", "ttf"));
    assertEquals("/Predicate must be provided/42", WebUtilities.mkPath("/", "Predicate must be provided", "42"));
    assertEquals("/Predicate must be provided/+", WebUtilities.mkPath("/", "Predicate must be provided", "/+"));
    assertEquals("/Predicate must be provided/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Predicate must be provided", "yyyy-MM-dd"));
    assertEquals("/Segs/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path"));
    assertEquals("/Segs/: Array was null", WebUtilities.mkPath("/", "Segs", ": Array was null"));
    assertEquals("/Segs/: Predicate was null", WebUtilities.mkPath("/", "Segs", ": Predicate was null"));
    assertEquals("/Segs/Array must be provided", WebUtilities.mkPath("/", "Segs", "Array must be provided"));
    assertEquals("/Segs/Predicate must be provided", WebUtilities.mkPath("/", "Segs", "Predicate must be provided"));
    assertEquals("/Segs/Segs", WebUtilities.mkPath("/", "Segs", "Segs"));
    assertEquals("/Segs/ttf", WebUtilities.mkPath("/", "Segs", "ttf"));
    assertEquals("/Segs/42", WebUtilities.mkPath("/", "Segs", "42"));
    assertEquals("/Segs/yyyy-MM-dd", WebUtilities.mkPath("/", "Segs", "yyyy-MM-dd"));
    assertEquals("/Segs/+", WebUtilities.mkPath("/", "Segs", "/+"));
    assertEquals("/ttf/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "ttf", "Cannot convert empty or null segments to path"));
    assertEquals("/ttf/: Array was null", WebUtilities.mkPath("/", "ttf", ": Array was null"));
    assertEquals("/ttf/: Predicate was null", WebUtilities.mkPath("/", "ttf", ": Predicate was null"));
    assertEquals("/ttf/Array must be provided", WebUtilities.mkPath("/", "ttf", "Array must be provided"));
    assertEquals("/ttf/Predicate must be provided", WebUtilities.mkPath("/", "ttf", "Predicate must be provided"));
    assertEquals("/ttf/Segs", WebUtilities.mkPath("/", "ttf", "Segs"));
    assertEquals("/ttf/ttf", WebUtilities.mkPath("/", "ttf", "ttf"));
    assertEquals("/ttf/42", WebUtilities.mkPath("/", "ttf", "42"));
    assertEquals("/ttf/yyyy-MM-dd", WebUtilities.mkPath("/", "ttf", "yyyy-MM-dd"));
    assertEquals("/ttf/+", WebUtilities.mkPath("/", "ttf", "/+"));
    assertEquals("/42/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path"));
    assertEquals("/42/: Array was null", WebUtilities.mkPath("/", "42", ": Array was null"));
    assertEquals("/42/: Predicate was null", WebUtilities.mkPath("/", "42", ": Predicate was null"));
    assertEquals("/42/Array must be provided", WebUtilities.mkPath("/", "42", "Array must be provided"));
    assertEquals("/42/Predicate must be provided", WebUtilities.mkPath("/", "42", "Predicate must be provided"));
    assertEquals("/42/Segs", WebUtilities.mkPath("/", "42", "Segs"));
    assertEquals("/42/ttf", WebUtilities.mkPath("/", "42", "ttf"));
    assertEquals("/42/42", WebUtilities.mkPath("/", "42", "42"));
    assertEquals("/42/yyyy-MM-dd", WebUtilities.mkPath("/", "42", "yyyy-MM-dd"));
    assertEquals("/42/+", WebUtilities.mkPath("/", "42", "/+"));
    assertEquals("/+/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path"));
    assertEquals("/+/: Array was null", WebUtilities.mkPath("/", "/+", ": Array was null"));
    assertEquals("/+/: Predicate was null", WebUtilities.mkPath("/", "/+", ": Predicate was null"));
    assertEquals("/+/Array must be provided", WebUtilities.mkPath("/", "/+", "Array must be provided"));
    assertEquals("/+/Predicate must be provided", WebUtilities.mkPath("/", "/+", "Predicate must be provided"));
    assertEquals("/+/Segs", WebUtilities.mkPath("/", "/+", "Segs"));
    assertEquals("/+/ttf", WebUtilities.mkPath("/", "/+", "ttf"));
    assertEquals("/+/42", WebUtilities.mkPath("/", "/+", "42"));
    assertEquals("/+/+", WebUtilities.mkPath("/", "/+", "/+"));
    assertEquals("/+/yyyy-MM-dd", WebUtilities.mkPath("/", "/+", "yyyy-MM-dd"));
    assertEquals("/yyyy-MM-dd/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Cannot convert empty or null segments to path"));
    assertEquals("/yyyy-MM-dd/: Array was null", WebUtilities.mkPath("/", "yyyy-MM-dd", ": Array was null"));
    assertEquals("/yyyy-MM-dd/: Predicate was null", WebUtilities.mkPath("/", "yyyy-MM-dd", ": Predicate was null"));
    assertEquals("/yyyy-MM-dd/Array must be provided",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Array must be provided"));
    assertEquals("/yyyy-MM-dd/Predicate must be provided",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Predicate must be provided"));
    assertEquals("/yyyy-MM-dd/Segs", WebUtilities.mkPath("/", "yyyy-MM-dd", "Segs"));
    assertEquals("/yyyy-MM-dd/ttf", WebUtilities.mkPath("/", "yyyy-MM-dd", "ttf"));
    assertEquals("/yyyy-MM-dd/42", WebUtilities.mkPath("/", "yyyy-MM-dd", "42"));
    assertEquals("/yyyy-MM-dd/yyyy-MM-dd", WebUtilities.mkPath("/", "yyyy-MM-dd", "yyyy-MM-dd"));
    assertEquals("/yyyy-MM-dd/+", WebUtilities.mkPath("/", "yyyy-MM-dd", "/+"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  void testAttemptRender() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, "Obj", new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("\"Obj\""));
  }

  /**
   * Method under test:
   * {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  void testAttemptRender2() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, 1, new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("1"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  void testAttemptRender3() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException("res must not be null")).when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, "Obj", new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("\"Obj\""));
  }

  /**
   * Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  void testGetLong() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualLong = WebUtilities.getLong(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(42L, actualLong);
  }

  /**
   * Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  void testGetLong2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLong(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  void testGetInt() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    int actualInt = WebUtilities.getInt(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(42, actualInt);
  }

  /**
   * Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  void testGetInt2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getInt(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  void testGetId() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualId = WebUtilities.getId(request);

    // Assert
    verify(request).params(eq("id"));
    assertEquals(42L, actualId);
  }

  /**
   * Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  void testGetId2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("id"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getId(request));
    verify(request).params(eq("id"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity4() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity5() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.ACTOR, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity6() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.APPLICATION, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  void testRequireEditRoleForEntity7() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.CHANGE_INITIATIVE, Operation.ADD,
        EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  void testRequireRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  void testRequireRole2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new HashSet<>());

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  void testRequireRole3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(false);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  void testRequireRole4() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  void testRequireRole5() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  void testRequireRole6() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, "Required Roles");

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  void testRequireRole7() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireRole8() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireRole9() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireRole10() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireRole11() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireAnyRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireAnyRole2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleService).hasAnyRole(eq("Attribute"), (SystemRole[]) any());
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test:
   * {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  void testRequireAnyRole3() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Method under test: {@link WebUtilities#getUsername(Request)}
   */
  @Test
  void testGetUsername() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    String actualUsername = WebUtilities.getUsername(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertEquals("Attribute", actualUsername);
  }

  /**
   * Method under test: {@link WebUtilities#getKind(Request)}
   */
  @Test
  void testGetKind() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("kind"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request));
    verify(request).params(eq("kind"));
  }

  /**
   * Method under test: {@link WebUtilities#getKind(Request, String)}
   */
  @Test
  void testGetKind2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  void testReadBody() throws UnsupportedEncodingException {
    // Arrange
    Request request = mock(Request.class);
    when(request.bodyAsBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Class<Object> objClass = Object.class;

    // Act
    Object actualReadBodyResult = WebUtilities.readBody(request, objClass, "Dflt");

    // Assert
    verify(request).bodyAsBytes();
    assertEquals("Dflt", actualReadBodyResult);
  }

  /**
   * Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  void testReadBody2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.bodyAsBytes()).thenReturn(new byte[]{});
    Class<Object> objClass = Object.class;

    // Act
    Object actualReadBodyResult = WebUtilities.readBody(request, objClass, "Dflt");

    // Assert
    verify(request).bodyAsBytes();
    assertEquals("Dflt", actualReadBodyResult);
  }

  /**
   * Method under test:
   * {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  void testReadEnum() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualReadEnumResult = WebUtilities.readEnum(request, "Param Name", enumClass,
        failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply(eq("Params"));
    verify(request).params(eq("Param Name"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Method under test:
   * {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  void testReadEnum2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("CONSTANT_ASCENT");
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;

    // Act
    Component.BaselineResizeBehavior actualReadEnumResult = WebUtilities.readEnum(request, "Param Name", enumClass,
        mock(Function.class));

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Method under test:
   * {@link WebUtilities#reportException(int, String, String, Response, Logger)}
   */
  @Test
  void testReportException() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());

    // Act
    WebUtilities.reportException(1, "An error occurred", "An error occurred", res,
        new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("{\"message\":\"An error occurred\",\"id\":\"An error occurred\"}"));
    verify(res).status(eq(1));
  }

  /**
   * Method under test:
   * {@link WebUtilities#reportException(int, Optional, String, Response, Logger)}
   */
  @Test
  void testReportException2() {
    // Arrange
    Optional<String> maybeErrorCode = Optional.of("foo");
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());

    // Act
    WebUtilities.reportException(1, maybeErrorCode, "An error occurred", res,
        new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("{\"message\":\"An error occurred\",\"id\":\"foo\"}"));
    verify(res).status(eq(1));
  }

  /**
   * Method under test: {@link WebUtilities#getMimeType(String)}
   */
  @Test
  void testGetMimeType() {
    // Arrange, Act and Assert
    assertEquals("application/octet-stream", WebUtilities.getMimeType("Path"));
    assertEquals("application/x-font-ttf", WebUtilities.getMimeType("ttf"));
  }

  /**
   * Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  void testGetLimit() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("42");

    // Act
    Optional<Integer> actualLimit = WebUtilities.getLimit(request);

    // Assert
    verify(request).queryParams(eq("limit"));
    assertEquals(42, actualLimit.get().intValue());
    assertTrue(actualLimit.isPresent());
  }

  /**
   * Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  void testGetLimit2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException("limit"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLimit(request));
    verify(request).queryParams(eq("limit"));
  }

  /**
   * Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  void testGetDateParam() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    Optional<Date> actualDateParam = WebUtilities.getDateParam(request);

    // Assert
    verify(request).queryParams(eq("date"));
    assertFalse(actualDateParam.isPresent());
  }

  /**
   * Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  void testGetDateParam2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException("date"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getDateParam(request));
    verify(request).queryParams(eq("date"));
  }

  /**
   * Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  void testGetLocalDateParam() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");

    // Act
    Optional<LocalDate> actualLocalDateParam = WebUtilities.getLocalDateParam(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertFalse(actualLocalDateParam.isPresent());
  }

  /**
   * Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  void testGetLocalDateParam2() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("yyyy-MM-dd"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLocalDateParam(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  void testSimplifyMapToList() {
    // Arrange and Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(new HashMap<>());

    // Assert
    assertTrue(actualSimplifyMapToListResult.isEmpty());
  }

  /**
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  void testSimplifyMapToList2() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put("42", "42");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(1, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    assertEquals("42", getResult.key());
    assertEquals("42", getResult.value());
  }

  /**
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  void testSimplifyMapToList3() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.computeIfPresent("42", mock(BiFunction.class));
    m.put("42", "42");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(1, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    assertEquals("42", getResult.key());
    assertEquals("42", getResult.value());
  }

  /**
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  void testSimplifyMapToList4() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put(42, "42");
    m.put("42", "42");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(2, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    Entry<Object, Object> getResult2 = actualSimplifyMapToListResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntry);
    assertEquals("42", getResult2.key());
    assertEquals("42", getResult.value());
    assertEquals("42", getResult2.value());
  }
}
