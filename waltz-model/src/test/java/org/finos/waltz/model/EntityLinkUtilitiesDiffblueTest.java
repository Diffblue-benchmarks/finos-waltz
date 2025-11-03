package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityLinkUtilitiesDiffblueTest {
  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink9() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink11() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink12() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink13() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink14() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink15() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1", EntityLinkUtilities
        .mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink16() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink17() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink18() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink19() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink20() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink21() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnEntityAggregateOverlayDiagramId123() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnEntityAggregateOverlayDiagramId9223372036854775807() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnEntityAggregateOverlayDiagramId9223372036854775808() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnEntityAggregateOverlayDiagramInstanceId123() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/123",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ACTOR/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityActorId123() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ACTOR/id/9223372036854775807'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityActorId9223372036854775807() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/-9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ACTOR/id/-9223372036854775808'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityActorId9223372036854775808() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId0() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId9() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId12() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAggregateOverlayDiagramId123() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ALL/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAllId123() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ALL/id/9223372036854775807'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAllId9223372036854775807() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/-9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ALL/id/-9223372036854775808'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAllId9223372036854775808() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); then return 'https:/example.org/example/entity/ALLOCATION/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_thenReturnHttpsExampleOrgExampleEntityAllocationId123() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/123",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When {@code baseUrl cannot be null}.</li>
   *   <li>Then return {@code baseUrl cannot be null/entity/ALL/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when 'baseUrl cannot be null'; then return 'baseUrl cannot be null/entity/ALL/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenBaseUrlCannotBeNull_thenReturnBaseUrlCannotBeNullEntityAllId1() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/ALL/id/1",
        EntityLinkUtilities.mkIdLink("baseUrl cannot be null", EntityKind.ALL, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code /entity/ACTOR/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return '/entity/ACTOR/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnEntityActorId8() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/8", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnEntityAggregateOverlayDiagramId8() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/8",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnEntityAggregateOverlayDiagramInstanceId8() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/8",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code /entity/ALL/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return '/entity/ALL/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnEntityAllId8() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/8", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return 'https:/example.org/example/entity/ACTOR/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnHttpsExampleOrgExampleEntityActorId8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return 'https:/example.org/example/entity/ALL/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnHttpsExampleOrgExampleEntityAllId8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when eight; then return 'https:/example.org/example/entity/ALLOCATION/id/8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenEight_thenReturnHttpsExampleOrgExampleEntityAllocationId8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/8",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 8L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code /entity/ACTOR/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return '/entity/ACTOR/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnEntityActorId5() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/5", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnEntityAggregateOverlayDiagramId5() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/5",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnEntityAggregateOverlayDiagramInstanceId5() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/5",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code /entity/ALL/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return '/entity/ALL/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnEntityAllId5() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/5", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return 'https:/example.org/example/entity/ACTOR/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnHttpsExampleOrgExampleEntityActorId5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return 'https:/example.org/example/entity/ALL/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnHttpsExampleOrgExampleEntityAllId5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/5}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when five; then return 'https:/example.org/example/entity/ALLOCATION/id/5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFive_thenReturnHttpsExampleOrgExampleEntityAllocationId5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/5",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 5L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code /entity/ACTOR/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return '/entity/ACTOR/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnEntityActorId4() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/4", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnEntityAggregateOverlayDiagramId4() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/4",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnEntityAggregateOverlayDiagramInstanceId4() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/4",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code /entity/ALL/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return '/entity/ALL/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnEntityAllId4() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/4", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return 'https:/example.org/example/entity/ACTOR/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnHttpsExampleOrgExampleEntityActorId4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return 'https:/example.org/example/entity/ALL/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnHttpsExampleOrgExampleEntityAllId4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when four; then return 'https:/example.org/example/entity/ALLOCATION/id/4'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenFour_thenReturnHttpsExampleOrgExampleEntityAllocationId4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/4",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 4L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@code /entity/ACTOR/id/9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when MAX_VALUE; then return '/entity/ACTOR/id/9223372036854775807'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMax_value_thenReturnEntityActorId9223372036854775807() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.</li>
   *   <li>Then return {@code /entity/ALL/id/9223372036854775807}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when MAX_VALUE; then return '/entity/ALL/id/9223372036854775807'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMax_value_thenReturnEntityAllId9223372036854775807() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/9223372036854775807",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, Long.MAX_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.</li>
   *   <li>Then return {@code /entity/ACTOR/id/-9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when MIN_VALUE; then return '/entity/ACTOR/id/-9223372036854775808'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMin_value_thenReturnEntityActorId9223372036854775808() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.</li>
   *   <li>Then return {@code /entity/ALL/id/-9223372036854775808}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when MIN_VALUE; then return '/entity/ALL/id/-9223372036854775808'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMin_value_thenReturnEntityAllId9223372036854775808() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/-9223372036854775808",
        EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, Long.MIN_VALUE));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code /entity/ACTOR/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return '/entity/ACTOR/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnEntityActorId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/-1", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnEntityAggregateOverlayDiagramId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/-1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnEntityAggregateOverlayDiagramInstanceId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/-1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code /entity/ALL/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return '/entity/ALL/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnEntityAllId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/-1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return 'https:/example.org/example/entity/ACTOR/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnHttpsExampleOrgExampleEntityActorId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return 'https:/example.org/example/entity/ALL/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnHttpsExampleOrgExampleEntityAllId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when minus one; then return 'https:/example.org/example/entity/ALLOCATION/id/-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenMinusOne_thenReturnHttpsExampleOrgExampleEntityAllocationId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/-1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, -1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code /entity/ACTOR/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return '/entity/ACTOR/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnEntityActorId9() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/9", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnEntityAggregateOverlayDiagramId9() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/9",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnEntityAggregateOverlayDiagramInstanceId9() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/9",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code /entity/ALL/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return '/entity/ALL/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnEntityAllId9() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/9", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return 'https:/example.org/example/entity/ACTOR/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnHttpsExampleOrgExampleEntityActorId9() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return 'https:/example.org/example/entity/ALL/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnHttpsExampleOrgExampleEntityAllId9() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when nine; then return 'https:/example.org/example/entity/ALLOCATION/id/9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenNine_thenReturnHttpsExampleOrgExampleEntityAllocationId9() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/9",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 9L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one hundred twenty-three.</li>
   *   <li>Then return {@code /entity/ACTOR/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one hundred twenty-three; then return '/entity/ACTOR/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOneHundredTwentyThree_thenReturnEntityActorId123() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/123", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one hundred twenty-three.</li>
   *   <li>Then return {@code /entity/ALL/id/123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one hundred twenty-three; then return '/entity/ALL/id/123'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOneHundredTwentyThree_thenReturnEntityAllId123() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/123", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 123L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code /entity/ACTOR/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return '/entity/ACTOR/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnEntityActorId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnEntityAggregateOverlayDiagramId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnEntityAggregateOverlayDiagramInstanceId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/1",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code /entity/ALL/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return '/entity/ALL/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnEntityAllId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code /entity/ALLOCATION/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return '/entity/ALLOCATION/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnEntityAllocationId1() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALLOCATION/id/1", EntityLinkUtilities.mkIdLink("/", EntityKind.ALLOCATION, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return 'https:/example.org/example/entity/ACTOR/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnHttpsExampleOrgExampleEntityActorId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return 'https:/example.org/example/entity/ALL/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnHttpsExampleOrgExampleEntityAllId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when one; then return 'https:/example.org/example/entity/ALLOCATION/id/1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenOne_thenReturnHttpsExampleOrgExampleEntityAllocationId1() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/1",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 1L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code /entity/ACTOR/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return '/entity/ACTOR/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnEntityActorId7() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/7", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnEntityAggregateOverlayDiagramId7() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/7",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnEntityAggregateOverlayDiagramInstanceId7() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/7",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code /entity/ALL/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return '/entity/ALL/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnEntityAllId7() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/7", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return 'https:/example.org/example/entity/ACTOR/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnHttpsExampleOrgExampleEntityActorId7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return 'https:/example.org/example/entity/ALL/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnHttpsExampleOrgExampleEntityAllId7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/7}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when seven; then return 'https:/example.org/example/entity/ALLOCATION/id/7'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSeven_thenReturnHttpsExampleOrgExampleEntityAllocationId7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/7",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 7L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code /entity/ACTOR/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return '/entity/ACTOR/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnEntityActorId6() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/6", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnEntityAggregateOverlayDiagramId6() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/6",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnEntityAggregateOverlayDiagramInstanceId6() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/6",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code /entity/ALL/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return '/entity/ALL/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnEntityAllId6() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/6", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return 'https:/example.org/example/entity/ACTOR/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnHttpsExampleOrgExampleEntityActorId6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return 'https:/example.org/example/entity/ALL/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnHttpsExampleOrgExampleEntityAllId6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/6}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when six; then return 'https:/example.org/example/entity/ALLOCATION/id/6'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenSix_thenReturnHttpsExampleOrgExampleEntityAllocationId6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/6",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 6L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code /entity/ACTOR/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return '/entity/ACTOR/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnEntityActorId10() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/10", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnEntityAggregateOverlayDiagramId10() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/10",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnEntityAggregateOverlayDiagramInstanceId10() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/10",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code /entity/ALL/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return '/entity/ALL/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnEntityAllId10() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/10", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return 'https:/example.org/example/entity/ACTOR/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnHttpsExampleOrgExampleEntityActorId10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return 'https:/example.org/example/entity/ALL/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnHttpsExampleOrgExampleEntityAllId10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when ten; then return 'https:/example.org/example/entity/ALLOCATION/id/10'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTen_thenReturnHttpsExampleOrgExampleEntityAllocationId10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/10",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 10L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code /entity/ACTOR/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return '/entity/ACTOR/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnEntityActorId3() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/3", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnEntityAggregateOverlayDiagramId3() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/3",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnEntityAggregateOverlayDiagramInstanceId3() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/3",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code /entity/ALL/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return '/entity/ALL/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnEntityAllId3() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/3", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return 'https:/example.org/example/entity/ACTOR/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnHttpsExampleOrgExampleEntityActorId3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return 'https:/example.org/example/entity/ALL/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnHttpsExampleOrgExampleEntityAllId3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when three; then return 'https:/example.org/example/entity/ALLOCATION/id/3'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenThree_thenReturnHttpsExampleOrgExampleEntityAllocationId3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/3",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 3L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code /entity/ACTOR/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return '/entity/ACTOR/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnEntityActorId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/2", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnEntityAggregateOverlayDiagramId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/2",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnEntityAggregateOverlayDiagramInstanceId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/2",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code /entity/ALL/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return '/entity/ALL/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnEntityAllId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/2", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return 'https:/example.org/example/entity/ACTOR/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnHttpsExampleOrgExampleEntityActorId2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return 'https:/example.org/example/entity/ALL/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnHttpsExampleOrgExampleEntityAllId2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when two; then return 'https:/example.org/example/entity/ALLOCATION/id/2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenTwo_thenReturnHttpsExampleOrgExampleEntityAllocationId2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/2",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 2L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code /entity/ACTOR/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return '/entity/ACTOR/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnEntityActorId0() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/id/0", EntityLinkUtilities.mkIdLink("/", EntityKind.ACTOR, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnEntityAggregateOverlayDiagramId0() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/id/0",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnEntityAggregateOverlayDiagramInstanceId0() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/id/0",
        EntityLinkUtilities.mkIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code /entity/ALL/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return '/entity/ALL/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnEntityAllId0() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/id/0", EntityLinkUtilities.mkIdLink("/", EntityKind.ALL, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return 'https:/example.org/example/entity/ACTOR/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnHttpsExampleOrgExampleEntityActorId0() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ACTOR, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return 'https:/example.org/example/entity/ALL/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnHttpsExampleOrgExampleEntityAllId0() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALL, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/id/0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkIdLink(String, EntityKind, Long)}
   */
  @Test
  @DisplayName("Test mkIdLink(String, EntityKind, Long); when zero; then return 'https:/example.org/example/entity/ALLOCATION/id/0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkIdLink(String, EntityKind, Long)"})
  void testMkIdLink_whenZero_thenReturnHttpsExampleOrgExampleEntityAllocationId0() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/id/0",
        EntityLinkUtilities.mkIdLink("https://example.org/example", EntityKind.ALLOCATION, 0L));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink2() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink3() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink4() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink5() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALL, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink6() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink7() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink8() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink9() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink10() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink11() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink12() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink13() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink14() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink15() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink16() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink17() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink18() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink19() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink20() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink21() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink22() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink23() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink24() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink25() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink26() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink27() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink28() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink29() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, ": Array was null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink30() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink31() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink32() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink33() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink34() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink35() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink36() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink37() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/kind cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink38() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/externalId cannot be null", EntityLinkUtilities
        .mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink39() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink40() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink41() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink42() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/Cannot convert empty or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink43() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink44() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("baseUrl cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink45() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/baseUrl cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink46() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/kind cannot be null", EntityLinkUtilities
        .mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink47() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION,
            "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink48() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink49() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink50() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink51() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, ": Array was null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink52() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink53() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            ": Array was null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink54() {
    // Arrange, Act and Assert
    assertEquals("kind cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink55() {
    // Arrange, Act and Assert
    assertEquals("externalId cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink56() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink57() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink58() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, ": Array was null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink59() {
    // Arrange, Act and Assert
    assertEquals("kind cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("kind cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink60() {
    // Arrange, Act and Assert
    assertEquals("externalId cannot be null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/", EntityLinkUtilities
        .mkExternalIdLink("externalId cannot be null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink61() {
    // Arrange, Act and Assert
    assertEquals("entity/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink62() {
    // Arrange, Act and Assert
    assertEquals("Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink63() {
    // Arrange, Act and Assert
    assertEquals("external-id/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink64() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Cannot convert empty or null segments to path",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink65() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code 42/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '42/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturn42EntityAggregateOverlayDiagramInstanceExternalId() {
    // Arrange, Act and Assert
    assertEquals("42/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("42", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/Cannot convert empty or null"
            + " segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.AGGREGATE_OVERLAY_DIAGRAM,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/Cannot convert empty"
            + " or null segments to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code : Array was null/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return ': Array was null/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnArrayWasNullEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code baseUrl cannot be null/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'baseUrl cannot be null/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnBaseUrlCannotBeNullEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code baseUrl cannot be null/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'baseUrl cannot be null/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnBaseUrlCannotBeNullEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code baseUrl cannot be null/entity/ALL/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'baseUrl cannot be null/entity/ALL/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnBaseUrlCannotBeNullEntityAllExternalId42() {
    // Arrange, Act and Assert
    assertEquals("baseUrl cannot be null/entity/ALL/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("baseUrl cannot be null", EntityKind.ALL, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnBaseUrlEntityAggregateOverlayDiagramExternalId() {
    // Arrange, Act and Assert
    assertEquals("Base Url/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ACTOR/external-id/baseUrl cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ACTOR/external-id/baseUrl cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityActorExternalIdBaseUrlCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ACTOR/external-id/externalId cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ACTOR/external-id/externalId cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityActorExternalIdExternalIdCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ACTOR/external-id/kind cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ACTOR/external-id/kind cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityActorExternalIdKindCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramExternalIdEntity() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramExternalIdExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramExternalIdExternalId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramInstanceExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAggregateOverlayDiagramInstanceExternalId42() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ALL/external-id/baseUrl cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ALL/external-id/baseUrl cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAllExternalIdBaseUrlCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/baseUrl cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ALL/external-id/externalId cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ALL/external-id/externalId cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAllExternalIdExternalIdCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/externalId cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code /entity/ALL/external-id/kind cannot be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return '/entity/ALL/external-id/kind cannot be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityAllExternalIdKindCannotBeNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/kind cannot be null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "kind cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code entity/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'entity/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnEntityEntityAggregateOverlayDiagramExternalId() {
    // Arrange, Act and Assert
    assertEquals("entity/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code externalId cannot be null/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'externalId cannot be null/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnExternalIdCannotBeNullEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("externalId cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code externalId cannot be null/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'externalId cannot be null/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnExternalIdCannotBeNullEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("externalId cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("externalId cannot be null", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code external-id/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'external-id/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnExternalIdEntityAggregateOverlayDiagramExternalId() {
    // Arrange, Act and Assert
    assertEquals("external-id/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ACTOR/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityActorExternalId42() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ACTOR/external-id/entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ACTOR/external-id/entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityActorExternalIdEntity() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ACTOR/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ACTOR, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ALL/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityAllExternalId42() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/external-id/entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ALL/external-id/entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityAllExternalIdEntity() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code https:/example.org/example/entity/ALLOCATION/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'https:/example.org/example/entity/ALLOCATION/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnHttpsExampleOrgExampleEntityAllocationExternalId() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALLOCATION/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code kind cannot be null/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'kind cannot be null/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnKindCannotBeNullEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("kind cannot be null/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>Then return {@code kind cannot be null/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); then return 'kind cannot be null/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_thenReturnKindCannotBeNullEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("kind cannot be null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("kind cannot be null", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '42/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturn42EntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("42/entity/ACTOR/external-id/", EntityLinkUtilities.mkExternalIdLink("42", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '42/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturn42EntityAggregateOverlayDiagramExternalId() {
    // Arrange, Act and Assert
    assertEquals("42/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/",
        EntityLinkUtilities.mkExternalIdLink("42", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '42/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturn42EntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("42/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("42", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code /entity/ACTOR/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '/entity/ACTOR/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturnEntityActorExternalId42() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/42", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code /entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturnEntityAggregateOverlayDiagramExternalId42() {
    // Arrange, Act and Assert
    assertEquals("/entity/AGGREGATE_OVERLAY_DIAGRAM/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.AGGREGATE_OVERLAY_DIAGRAM, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when '42'; then return '/entity/ALL/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_when42_thenReturnEntityAllExternalId42() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/42", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then return {@code /entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'ACTOR'; then return '/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenActor_thenReturnEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code ALL}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'ALL'; then return '/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenAll_thenReturnEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code ALL}.</li>
   *   <li>Then return {@code https:/example.org/example/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'ALL'; then return 'https:/example.org/example/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenAll_thenReturnHttpsExampleOrgExampleEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("https:/example.org/example/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code ALLOCATION}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'ALLOCATION'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenAllocation_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "https:/example.org/example/entity/ALLOCATION/external-id/Cannot convert empty or null segments" + " to path",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example", EntityKind.ALLOCATION,
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code ALLOCATION}.</li>
   *   <li>Then return {@code /entity/ALLOCATION/external-id/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'ALLOCATION'; then return '/entity/ALLOCATION/external-id/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenAllocation_thenReturnEntityAllocationExternalId42() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALLOCATION/external-id/42",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALLOCATION, "42"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   *   <li>Then return {@code : Array was null/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when ': Array was null'; then return ': Array was null/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenArrayWasNull_thenReturnArrayWasNullEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink(": Array was null", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code : Array was null}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when ': Array was null'; then return '/entity/ALL/external-id/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenArrayWasNull_thenReturnEntityAllExternalIdArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/: Array was null",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, ": Array was null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code baseUrl cannot be null}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'baseUrl cannot be null'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenBaseUrlCannotBeNull_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/baseUrl cannot" + " be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "baseUrl cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code Base Url}.</li>
   *   <li>Then return {@code Base Url/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'Base Url'; then return 'Base Url/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenBaseUrl_thenReturnBaseUrlEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("Base Url/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code Base Url}.</li>
   *   <li>Then return {@code Base Url/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'Base Url'; then return 'Base Url/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenBaseUrl_thenReturnBaseUrlEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("Base Url/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("Base Url", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code entity}.</li>
   *   <li>Then return {@code /entity/ACTOR/external-id/entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'entity'; then return '/entity/ACTOR/external-id/entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenEntity_thenReturnEntityActorExternalIdEntity() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/entity",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code entity}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'entity'; then return '/entity/ALL/external-id/entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenEntity_thenReturnEntityAllExternalIdEntity() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/entity", EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "entity"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code entity}.</li>
   *   <li>Then return {@code entity/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'entity'; then return 'entity/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenEntity_thenReturnEntityEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("entity/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code entity}.</li>
   *   <li>Then return {@code entity/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'entity'; then return 'entity/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenEntity_thenReturnEntityEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("entity/entity/ALL/external-id/", EntityLinkUtilities.mkExternalIdLink("entity", EntityKind.ALL, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code externalId cannot be null}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'externalId cannot be null'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalIdCannotBeNull_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "https:/example.org/example/entity/AGGREGATE_OVERLAY_DIAGRAM_INSTANCE/external-id/externalId cannot"
            + " be null",
        EntityLinkUtilities.mkExternalIdLink("https://example.org/example",
            EntityKind.AGGREGATE_OVERLAY_DIAGRAM_INSTANCE, "externalId cannot be null"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code External Id}.</li>
   *   <li>Then return {@code /entity/ACTOR/external-id/External Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'External Id'; then return '/entity/ACTOR/external-id/External Id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnEntityActorExternalIdExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code external-id}.</li>
   *   <li>Then return {@code /entity/ACTOR/external-id/external-id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'external-id'; then return '/entity/ACTOR/external-id/external-id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnEntityActorExternalIdExternalId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/ACTOR/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ACTOR, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code External Id}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/External Id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'External Id'; then return '/entity/ALL/external-id/External Id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnEntityAllExternalIdExternalId() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/External Id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "External Id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code external-id}.</li>
   *   <li>Then return {@code /entity/ALL/external-id/external-id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'external-id'; then return '/entity/ALL/external-id/external-id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnEntityAllExternalIdExternalId2() {
    // Arrange, Act and Assert
    assertEquals("/entity/ALL/external-id/external-id",
        EntityLinkUtilities.mkExternalIdLink("/", EntityKind.ALL, "external-id"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code external-id}.</li>
   *   <li>Then return {@code external-id/entity/ACTOR/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'external-id'; then return 'external-id/entity/ACTOR/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnExternalIdEntityActorExternalId() {
    // Arrange, Act and Assert
    assertEquals("external-id/entity/ACTOR/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.ACTOR, "/"));
  }

  /**
   * Test {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}.
   * <ul>
   *   <li>When {@code external-id}.</li>
   *   <li>Then return {@code external-id/entity/ALL/external-id/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLinkUtilities#mkExternalIdLink(String, EntityKind, String)}
   */
  @Test
  @DisplayName("Test mkExternalIdLink(String, EntityKind, String); when 'external-id'; then return 'external-id/entity/ALL/external-id/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String EntityLinkUtilities.mkExternalIdLink(String, EntityKind, String)"})
  void testMkExternalIdLink_whenExternalId_thenReturnExternalIdEntityAllExternalId() {
    // Arrange, Act and Assert
    assertEquals("external-id/entity/ALL/external-id/",
        EntityLinkUtilities.mkExternalIdLink("external-id", EntityKind.ALL, "/"));
  }
}
