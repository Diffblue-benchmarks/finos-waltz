package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EntityLinkUtilitiesDiffblueTest {
  /**
   * Method under test:
   * {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  void testMkIdLink() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 1L));
    assertEquals("/entity/ALL/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 1L));
    assertEquals("baseUrl cannot be null/entity/ALL/id/1",
        EntityLinkUtilities.mkIdLink("baseUrl cannot be null", EntityKind.ALL, 1L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 1L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 1L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 1L));
    assertEquals("https:/example.org/example/entity/ALL/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 2L));
    assertEquals("https:/example.org/example/entity/ALL/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 3L));
    assertEquals("https:/example.org/example/entity/ALL/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 4L));
    assertEquals("https:/example.org/example/entity/ALL/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 5L));
    assertEquals("https:/example.org/example/entity/ALL/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 6L));
    assertEquals("https:/example.org/example/entity/ALL/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 7L));
    assertEquals("https:/example.org/example/entity/ALL/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 8L));
    assertEquals("https:/example.org/example/entity/ALL/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 9L));
    assertEquals("https:/example.org/example/entity/ALL/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 10L));
    assertEquals("https:/example.org/example/entity/ALL/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 123L));
    assertEquals("https:/example.org/example/entity/ALL/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 0L));
    assertEquals("https:/example.org/example/entity/ALL/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, -1L));
    assertEquals("https:/example.org/example/entity/ALL/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, Long.MAX_VALUE));
    assertEquals("https:/example.org/example/entity/ALL/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, Long.MIN_VALUE));
    assertEquals("/entity/ACTOR/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 1L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 1L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 1L));
    assertEquals("/entity/ALL/id/2", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 2L));
    assertEquals("/entity/ALL/id/3", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 3L));
    assertEquals("/entity/ALL/id/4", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 4L));
    assertEquals("/entity/ALL/id/5", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 5L));
    assertEquals("/entity/ALL/id/6", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 6L));
    assertEquals("/entity/ALL/id/7", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 7L));
    assertEquals("/entity/ALL/id/8", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 8L));
    assertEquals("/entity/ALL/id/9", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 9L));
    assertEquals("/entity/ALL/id/10", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 10L));
    assertEquals("/entity/ALL/id/123", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 123L));
    assertEquals("/entity/ALL/id/0", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 0L));
    assertEquals("/entity/ALL/id/-1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, -1L));
    assertEquals("/entity/ALL/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, Long.MAX_VALUE));
    assertEquals("/entity/ALL/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, Long.MIN_VALUE));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 1L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 2L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 3L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 4L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 5L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 6L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 7L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 8L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 9L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 10L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 123L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 0L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, -1L));
    assertEquals("https:/example.org/example/entity/ACTOR/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, Long.MAX_VALUE));
    assertEquals("https:/example.org/example/entity/ACTOR/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, Long.MIN_VALUE));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 2L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 3L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 4L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 5L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 6L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 7L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 8L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 9L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 10L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 123L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 0L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, -1L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            Long.MAX_VALUE));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            Long.MIN_VALUE));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 2L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 3L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 4L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 5L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 6L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 7L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 8L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 9L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 10L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 123L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 0L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, -1L));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            Long.MAX_VALUE));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            Long.MIN_VALUE));
    assertEquals("/entity/ALLOCATION/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALLOCATION, 1L));
    assertEquals("/entity/ACTOR/id/2", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 2L));
    assertEquals("/entity/ACTOR/id/3", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 3L));
    assertEquals("/entity/ACTOR/id/4", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 4L));
    assertEquals("/entity/ACTOR/id/5", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 5L));
    assertEquals("/entity/ACTOR/id/6", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 6L));
    assertEquals("/entity/ACTOR/id/7", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 7L));
    assertEquals("/entity/ACTOR/id/8", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 8L));
    assertEquals("/entity/ACTOR/id/9", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 9L));
    assertEquals("/entity/ACTOR/id/10", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 10L));
    assertEquals("/entity/ACTOR/id/123", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 123L));
    assertEquals("/entity/ACTOR/id/0", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 0L));
    assertEquals("/entity/ACTOR/id/-1", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, -1L));
    assertEquals("/entity/ACTOR/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, Long.MAX_VALUE));
    assertEquals("/entity/ACTOR/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, Long.MIN_VALUE));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 2L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 3L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 4L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 5L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 6L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 7L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 8L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 9L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 10L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 123L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 0L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, -1L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, Long.MAX_VALUE));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, Long.MIN_VALUE));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 2L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 3L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 4L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 5L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 6L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 7L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 8L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 9L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 10L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 123L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 0L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, -1L));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, Long.MAX_VALUE));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, Long.MIN_VALUE));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 2L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 3L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 4L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 5L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 6L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 7L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 8L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 9L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 10L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 123L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 0L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, -1L));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, Long.MAX_VALUE));
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, Long.MIN_VALUE));
  }

  /**
   * Method under test:
   * {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  void testMkExternalIdLink() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "42"));
    assertEquals("/entity/ALL/external-id/42", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "42"));
    assertEquals("baseUrl cannot be null/entity/ALL/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ALL, "42"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "42"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "42"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "42"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "/"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "baseUrl cannot be null"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "kind cannot be null"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALL, "externalId cannot be null"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "External Id"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "entity"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "external-id"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL,
            "Cannot convert empty or null segments to path"));
    assertEquals("/entity/ACTOR/external-id/42", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "42"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "42"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "42"));
    assertEquals("/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "/"));
    assertEquals("/entity/ALL/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "baseUrl cannot be null"));
    assertEquals("/entity/ALL/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "kind cannot be null"));
    assertEquals("/entity/ALL/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "externalId cannot be null"));
    assertEquals("/entity/ALL/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "External Id"));
    assertEquals("/entity/ALL/external-id/entity", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "entity"));
    assertEquals("/entity/ALL/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "external-id"));
    assertEquals("/entity/ALL/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "Cannot convert empty or null segments to path"));
    assertEquals("baseUrl cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ALL, "/"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "42"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "/"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "baseUrl cannot be null"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "kind cannot be null"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "externalId cannot be null"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "External Id"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "entity"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "external-id"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR,
            "Cannot convert empty or null segments to path"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "baseUrl cannot be null"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "kind cannot be null"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "externalId cannot be null"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "External Id"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "entity"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "external-id"));
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/Cannot convert empty or null"
            + " segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "Cannot convert empty or null segments to path"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/baseUrl cannot" + " be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "baseUrl cannot be null"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "kind cannot be null"));
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/externalId cannot"
            + " be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "externalId cannot be null"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "External Id"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "entity"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "external-id"));
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/Cannot convert empty"
            + " or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "Cannot convert empty or null segments to path"));
    assertEquals("https:/example.org/example/entity/ALL/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, ": Array was null"));
    assertEquals("kind cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.ALL, "/"));
    assertEquals("externalId cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.ALL, "/"));
    assertEquals("entity/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.ALL, "/"));
    assertEquals("Base Url/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.ALL, "/"));
    assertEquals("external-id/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.ALL, "/"));
    assertEquals("42/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("42", EntityKind.ALL, "/"));
    assertEquals("Cannot convert empty or null segments to path/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path", EntityKind.ALL, "/"));
    assertEquals(": Array was null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.ALL, "/"));
    assertEquals("/entity/ALLOCATION/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALLOCATION, "42"));
    assertEquals("/entity/ACTOR/external-id/", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "/"));
    assertEquals("/entity/ACTOR/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "baseUrl cannot be null"));
    assertEquals("/entity/ACTOR/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "kind cannot be null"));
    assertEquals("/entity/ACTOR/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "externalId cannot be null"));
    assertEquals("/entity/ACTOR/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "External Id"));
    assertEquals("/entity/ACTOR/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "entity"));
    assertEquals("/entity/ACTOR/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "external-id"));
    assertEquals("/entity/ACTOR/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "Cannot convert empty or null segments to path"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "baseUrl cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "kind cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "externalId cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "External Id"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "entity"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "external-id"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "Cannot convert empty or null segments to path"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "baseUrl cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/kind cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "kind cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "externalId cannot be null"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "External Id"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "entity"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "external-id"));
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            "Cannot convert empty or null segments to path"));
    assertEquals("/entity/ALL/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, ": Array was null"));
    assertEquals("baseUrl cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ACTOR, "/"));
    assertEquals("baseUrl cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("baseUrl cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("baseUrl cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "/"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "baseUrl cannot be null"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/kind cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "kind cannot be null"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION,
            "externalId cannot be null"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "External Id"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "entity"));
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "external-id"));
    assertEquals(
        "https:/example.org/example/entity/ALLOCATION/external-id/Cannot convert empty or null segments" + " to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION,
            "Cannot convert empty or null segments to path"));
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, ": Array was null"));
    assertEquals("kind cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.ACTOR, "/"));
    assertEquals("externalId cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.ACTOR, "/"));
    assertEquals("entity/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.ACTOR, "/"));
    assertEquals("Base Url/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.ACTOR, "/"));
    assertEquals("external-id/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.ACTOR, "/"));
    assertEquals("42/entity/ACTOR/external-id/", EntityLinkUtilities.mkExternalIdLink("42", EntityKind.ACTOR, "/"));
    assertEquals("Cannot convert empty or null segments to path/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path", EntityKind.ACTOR, "/"));
    assertEquals(": Array was null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.ACTOR, "/"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            ": Array was null"));
    assertEquals("kind cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("externalId cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("entity/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("external-id/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("42/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("42", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("Cannot convert empty or null segments to path/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals(": Array was null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, ": Array was null"));
    assertEquals("kind cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("kind cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("externalId cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("externalId cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("entity/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("external-id/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("42/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("42", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals("Cannot convert empty or null segments to path/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
    assertEquals(": Array was null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }
}
