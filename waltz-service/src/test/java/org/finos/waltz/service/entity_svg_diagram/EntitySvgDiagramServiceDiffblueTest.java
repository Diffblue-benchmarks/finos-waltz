package org.finos.waltz.service.entity_svg_diagram;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.entity_svg_diagram.EntitySvgDiagramDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.entity_svg_diagram.EntitySvgDiagram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntitySvgDiagramServiceDiffblueTest {
  /**
   * Test {@link EntitySvgDiagramService#findForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntitySvgDiagramService#findForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntitySvgDiagramService.findForEntityReference(EntityReference)"})
  void testFindForEntityReference_thenReturnEmpty() {
    // Arrange
    EntitySvgDiagramDao entitySvgDiagramDao = mock(EntitySvgDiagramDao.class);
    when(entitySvgDiagramDao.findForEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());
    EntitySvgDiagramService entitySvgDiagramService =
        new EntitySvgDiagramService(entitySvgDiagramDao);

    // Act
    List<EntitySvgDiagram> actualFindForEntityReferenceResult =
        entitySvgDiagramService.findForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(entitySvgDiagramDao).findForEntityReference(isA(EntityReference.class));
    assertTrue(actualFindForEntityReferenceResult.isEmpty());
  }
}
